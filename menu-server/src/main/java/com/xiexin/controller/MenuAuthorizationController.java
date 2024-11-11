package com.xiexin.controller;

import com.xiexin.entity.Menu;
import com.xiexin.entity.Result;
import com.xiexin.service.MenuAuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/menus/Authorization")
public class MenuAuthorizationController {
    @Autowired
    MenuAuthorizationService menuAuthorizationService;

    @GetMapping
    public Result getAuthorizedMenu(){
        log.info("获取菜单授权");
        return Result.success("获取菜单授权列表成功",menuAuthorizationService.getList());
    }

    @PostMapping
    public Result editStatus(@RequestBody Menu menu){
        log.info("修改菜单状态");
        menuAuthorizationService.editStatus(menu);
        return Result.success("修改菜单状态成功");
    }

    @GetMapping("/{id}")
    public Result getSpAuthorizedMenu(@PathVariable Integer id){
        log.info("获取具体菜单授权信息");
        return Result.success("获取具体菜单授权信息成功",menuAuthorizationService.getStatus(id));
    }
}
