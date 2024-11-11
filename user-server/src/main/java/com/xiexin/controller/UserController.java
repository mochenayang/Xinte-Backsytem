package com.xiexin.controller;

import com.xiexin.entity.Result;
import com.xiexin.entity.User;
import com.xiexin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users/lists")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Result getUserList(@RequestParam("dept") Integer dept,
                              @RequestParam("page") Integer page,
                              @RequestParam("pageSize") Integer pageSize){
        log.info("获取用户列表{},{},{}",dept,page,pageSize);
        return Result.success("获取用户列表成功",userService.page(dept,page,pageSize));
    }

    @PostMapping
    public Result addUserList(@RequestBody User user){
        log.info("新增用户");
        if(userService.addUser(user) == null){
            return Result.error("新增用户失败");
        }
        return Result.success("新增用户成功");
    }

    @DeleteMapping
    public Result deleteUseList(@RequestParam("ids") List<Integer> user_ids){
        log.info("删除用户");
        userService.deleteIds(user_ids);
        return Result.success("删除用户成功");
    }

    @PutMapping
    public Result updateUserList(@RequestBody User user){
        log.info("更新用户");
        userService.updateUser(user);
        return Result.success("修改用户信息成功");
    }
}
