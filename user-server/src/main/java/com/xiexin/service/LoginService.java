package com.xiexin.service;

import com.xiexin.entity.User;
import com.xiexin.mapper.UserMapper;
import com.xiexin.utils.JwtUtils;
import io.jsonwebtoken.Claims;
//import jakarta.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Cacheable(cacheNames = "userCache#604800",key="#user.username",unless = "#result==null")
    public String login(User user) {
        System.out.println(userMapper.findUser(user));
        if (userMapper.findUser(user) != null){
            // 登录成功
            Map<String,Object> claims = new HashMap<>();
            claims.put("username",userMapper.findUser(user).getUsername());
            claims.put("role",userMapper.findUser(user).getRole_id());
            claims.put("user_id",userMapper.findUser(user).getUser_id());
            System.out.println(userMapper.findUser(user).getUser_id());
            return "Bearer " + jwtUtils.getJwt(claims);
        }
        return null;
    }

    @Cacheable(cacheNames = "userCache#604800",key = "#request.getHeader('Authorization')")
    public Claims getUserInfo(HttpServletRequest request){
        if (request.getHeader("Authorization")!=null && request.getHeader("Authorization").startsWith("Bearer ")){
            String token = request.getHeader("Authorization").substring(7);
            return jwtUtils.parseJwt(token);
        }
        return null;
    }

}
