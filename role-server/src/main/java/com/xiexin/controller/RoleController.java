package com.xiexin.controller;

import com.xiexin.entity.Result;
import com.xiexin.entity.Role;
import com.xiexin.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * 角色管理Controller
 * */
@Slf4j
@RestController
@RequestMapping("/rolelist")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public Result getRoleList(@RequestParam("page") Integer page,
                              @RequestParam("pageSize") Integer pageSize){
        log.info("获取角色列表{},{}",page,pageSize);
        if(roleService.getRoleList(page,pageSize) == null){
            return Result.error("获取角色列表失败");
        }
        return Result.success("获得角色列表成功", roleService.getRoleList(page,pageSize));
    }

    @PostMapping
    public Result addRoleList(@RequestBody Role role){
        log.info("新增角色");
        roleService.addRoleList(role);
        return Result.success("新增角色成功");
    }

    @DeleteMapping
    public Result deleteRoleList(@RequestParam("ids") List<Integer> role_ids){
        log.info("删除角色");
        roleService.deleteRoleList(role_ids);
        return Result.success("删除角色成功");
    }

    @PutMapping
    public Result updateRoleList(@RequestBody Role role){
        log.info("编辑角色");
        roleService.updateRoleList(role);
        return Result.success("编辑角色成功");
    }
}
