package com.xiexin.service;

import com.xiexin.entity.User;
import com.xiexin.mapper.UserMapper;
import com.xiexin.utils.RedisUtils;
import com.xiexin.utils.VerCodeGenerateUtil;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegisterService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserMapper userMapper;

    //这个是邮件类，必须要导入哦
    @Autowired
    JavaMailSenderImpl mailSender;

    public String register(User user){
        String code = (String) redisUtils.get("userCache:"+user.getEmail());
//        System.out.println(code.equals(user.getCode()));
        if(code == null){
            return "验证码过期，请重新发送";
        }
        if(!code.equals(user.getCode())){
            return "验证码错误";
        }
        user.setCreate_time(LocalDateTime.now());
        user.setEdit_time(LocalDateTime.now());
        userMapper.insertUser(user);
        return "success";
    }

    @Cacheable(cacheNames = "userCache#180",key="#email",unless="#result==null")
    public String sendCode(String email){
        // 获得验证码
        String verCode = VerCodeGenerateUtil.getVerCode();

        // 以下为发送邮件部分
        MimeMessage mimeMessage = null;
        MimeMessageHelper helper = null;
        try {
            //发送复杂的邮件
            mimeMessage = mailSender.createMimeMessage();
            //组装
            helper = new MimeMessageHelper(mimeMessage,true);
            //邮件标题
            helper.setSubject("【平台】 注册账号验证码");
            //因为设置了邮件格式所以html标签有点多，后面的ture为支持识别html标签
            //想要不一样的邮件格式，百度搜索一个html编译器，自我定制。
            helper.setText("<h3>\n" +
                    "\t<span style=\"font-size:16px;\">亲爱的用户：</span> \n" +
                    "</h3>\n" +
                    "<p>\n" +
                    "\t<span style=\"font-size:14px;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"font-size:14px;\">&nbsp; <span style=\"font-size:16px;\">&nbsp;&nbsp;您好！您正在进行邮箱验证，本次请求的验证码为：<span style=\"font-size:24px;color:#FFE500;\"> "+verCode+"</span>,本验证码3分钟内有效，请在3分钟内完成验证。（请勿泄露此验证码）如非本人操作，请忽略该邮件。(这是一封自动发送的邮件，请不要直接回复）</span></span>\n" +
                    "</p>\n" +
                    "<p style=\"text-align:right;\">\n" +
                    "\t<span style=\"background-color:#FFFFFF;font-size:16px;color:#000000;\"><span style=\"color:#000000;font-size:16px;background-color:#FFFFFF;\"><span class=\"token string\" style=\"font-family:&quot;font-size:16px;color:#000000;line-height:normal !important;background-color:#FFFFFF;\">平台</span></span></span> \n" +
                    "</p>\n" ,true);
            //收件人
            helper.setTo(email);
            //发送方
            helper.setFrom(from);
            try {
                // 发送邮件
                mailSender.send(mimeMessage);
            }catch (MailException e){
                return null;
            }
        }catch(MessagingException e){
            return null;
        }
        return verCode;
    }
}
