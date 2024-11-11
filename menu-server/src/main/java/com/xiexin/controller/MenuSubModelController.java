package com.xiexin.controller;

import com.xiexin.entity.MenuSubModel;
import com.xiexin.entity.Result;
import com.xiexin.service.MenuSubModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/menus/submodel")
public class MenuSubModelController {
    @Autowired
    MenuSubModelService menuSubModelService;

    @GetMapping("/{id}")
    public Result getMenuSubModel(@PathVariable Integer id){
        return Result.success("获取具体点位信息成功",menuSubModelService.getSubList(id));
    }

    @PostMapping
    public Result addMenuSubModel(@RequestBody MenuSubModel menuSubModel){
        menuSubModelService.addSubModel(menuSubModel);
        return Result.success("新增点位成功");
    }

    @PutMapping
    public Result editMenuSubModel(@RequestBody List<Integer> labels){
        System.out.println(labels);
        menuSubModelService.updateMenuSubModel(labels);
        return Result.success("修改点位信息成功");
    }

    @DeleteMapping
    public Result deleteMenuSubModel(@RequestParam("ids") List<Integer> ids){
        menuSubModelService.deleteMenuSubModel(ids);
        return Result.success("删除点位信息成功");
    }
}
