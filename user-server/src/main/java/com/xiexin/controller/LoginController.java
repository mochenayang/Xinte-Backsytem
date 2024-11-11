package com.xiexin.controller;

import com.xiexin.entity.Result;
import com.xiexin.entity.User;
import com.xiexin.service.LogService;
import com.xiexin.service.LoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
//import jakarta.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    private LogService logService;

    @GetMapping
    public String getUsers(@RequestParam("id") Integer id){
        System.out.println(id);
        return id.toString();
    }

    /*
     * 用户登录接口
     *  Post请求
     * */
    @PostMapping("/login")
    public Result userLogin(@RequestBody User user){
        log.info("用户登录");
        String token = loginService.login(user);
        if(token == null){
            return Result.error("请检查用户名和密码");
        }
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("token",token);
        return Result.success("用户登录成功",hashMap);
    }

    /*
     *获取用户以及权限
     *Get请求
     * */
    @GetMapping("/info")
    public Result getUserInfo(HttpServletRequest request){
        log.info("获取用户以及权限");
        Claims result = null;
        try {
            result = loginService.getUserInfo(request);
        } catch (ExpiredJwtException e) {
            return Result.error("认证已到期");
        }
        if( result== null){
            return Result.error("获取用户姓名和权限失败");
        }
        return Result.success("获取用户姓名和权限成功", result);
    }

    private void logLogin(Long userId, String username, String ip, String address, String status) {
        Map<String, Object> logInfo = new HashMap<>();
        logInfo.put("userId", userId);
        logInfo.put("username", username);
        logInfo.put("ip", ip);
        logInfo.put("timestamp", new java.util.Date());
        logInfo.put("status", status);
        logInfo.put("address", address);

        logService.recordLoginLog(logInfo);
    }

}
