package com.xiexin.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiexin.entity.Result;
import com.xiexin.entity.User;
import com.xiexin.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("用户注册");
        if (!registerService.register(user).equals("success")){
            return Result.error(registerService.register(user));
        }
        return Result.success("用户注册成功");
    }

    @PostMapping("/code")
    public Result sendCode(@RequestBody JSONObject params){
        log.info("获取验证码");
        String email = params.get("email").toString();
        // System.out.println(params.get("email").toString());
        String code = registerService.sendCode(email);
        if (code == null) {
            return Result.error("发送验证码失败");
        }
        return Result.success("发送验证码成功");
    }
}
