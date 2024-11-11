package com.xiexin.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {
    public static final int EXPIRE_TIME = 604800;

    public String getJwt(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims) // 自定义内容(载荷)
                .signWith(SignatureAlgorithm.HS256, "zyz".getBytes()) //签名算法
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRE_TIME))
                .compact();
    }

    public Claims parseJwt(String jwt){
        return Jwts.parser()
                .setSigningKey("zyz".getBytes())
                .parseClaimsJws(jwt)
                .getBody();
    }
}
