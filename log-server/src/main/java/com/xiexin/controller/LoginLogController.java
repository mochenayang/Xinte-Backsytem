package com.xiexin.controller;
import com.xiexin.dto.LoginLogQuery;

import com.xiexin.entity.LoginLog;
import com.xiexin.service.LoginLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/loglists/login-logs")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    // 获取所有登录日志，直接分页显示
    @GetMapping
    public PageInfo<LoginLog> getLoginLogs(LoginLogQuery query) {
        if (query == null) {
            throw new IllegalArgumentException("查询参数不能为 null");
        }

        // 使用 PageHelper 开启分页
        PageHelper.startPage(query.getPage(), query.getLimit());

        // 获取分页登录日志
        List<LoginLog> logs = loginLogService.getLogsWithPagination(query);

        // 创建 PageInfo 对象
        PageInfo<LoginLog> pageInfo = new PageInfo<>(logs);

        // 获取总记录数
        long totalRecords = loginLogService.getTotalLogCount(query);
        pageInfo.setTotal(totalRecords);

        return pageInfo;
    }

}