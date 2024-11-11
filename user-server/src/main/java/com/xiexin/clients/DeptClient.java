package com.xiexin.clients;

import com.xiexin.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("deptservice")
public interface DeptClient {

    @GetMapping("/deptlist/all")
    List<Dept> getAll();

}
