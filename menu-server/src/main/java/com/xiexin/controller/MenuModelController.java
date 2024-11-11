package com.xiexin.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiexin.entity.Result;
import com.xiexin.service.MenuModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/menus/model")
public class MenuModelController {
    @Autowired
    MenuModelService menuModelService;

    @GetMapping("/{id}")
    public Result getMenuModelList(@PathVariable Integer id){
        log.info("获取页面菜单模型");
        return Result.success("获取页面菜单模型成功",menuModelService.getMenuModel(id));
    }

    @PostMapping
    public Result addMenuModel(@RequestBody JSONObject params){
        String name = (String) params.get("name");
        menuModelService.addMenuModel(name);
        return Result.success("新增子模型成功");
    }
}
