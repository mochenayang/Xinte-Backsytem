package com.xiexin.controller;

import com.xiexin.entity.Dept;
import com.xiexin.entity.Result;
import com.xiexin.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/deptlist")
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping
    public Result getDeptList(){
        log.info("获取组织架构");
        return Result.success("获取组织架构成功",deptService.getDeptList());
    }

    @PostMapping
    public Result addDeptList(@RequestBody Dept dept){
        log.info("新增组织架构");

        deptService.addDept(dept);
        return Result.success("新增组织架构成功");
    }

    @PutMapping
    public Result editDeptList(@RequestBody Dept dept){
        log.info("编辑组织架构");
        deptService.editDept(dept);
        return Result.success("编辑组织架构成功");
    }

    @DeleteMapping
    public Result deleteDeptList(@RequestParam("id") Integer id){
        Dept dept = new Dept();
        dept.setId(id);
        System.out.println(dept);
        log.info("删除组织架构");
        deptService.deleteDept(dept);
        return Result.success("删除组织架构成功");
    }

    @GetMapping("/all")
    public List<Dept> getAllDeptList(){
        log.info("获取所有组织架构信息");
        return deptService.getAllList();
    }
}
