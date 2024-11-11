package com.xiexin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer user_id;
    private String username;
    private String name;
    private String password;
    private Integer role_id;
    private String role;
    private Integer dept;
    private String email;
    private String code;
    private String phonenumber;
    private String position;
    private String sex;
    private Integer age;
    private String address;
    private LocalDateTime create_time; //创建时间
    private LocalDateTime edit_time; //修改时间
}
