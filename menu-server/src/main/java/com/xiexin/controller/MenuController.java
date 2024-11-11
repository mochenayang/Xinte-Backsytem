package com.xiexin.controller;


import com.xiexin.entity.Menu;
import com.xiexin.entity.Result;
import com.xiexin.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping
    public Result getMenuList(){
        log.info("获取菜单列表");
        return Result.success("获取菜单列表成功",menuService.getMenuList());
    }

    @PostMapping
    public Result addMenuList(@RequestBody Menu menu){
        log.info("新增菜单");
        menuService.addMenuList(menu);
        return Result.success("新增菜单成功");
    }

    @DeleteMapping("/{id}")
    public Result deleteMenuList(@PathVariable Integer id){
        log.info("删除菜单");
        menuService.deleteMenuList(id);
        return Result.success("删除菜单成功");
    }

    @PutMapping
    public Result editMenuList(@RequestBody Menu menu){
        log.info("编辑菜单");
        menuService.editMenuList(menu);
        return Result.success("编辑菜单成功");
    }
}
