package com.xiexin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiexin.dto.OperationLogQuery;
import com.xiexin.entity.OperationLog;
import com.xiexin.service.OperationLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loglists/operation-logs")
public class OperationLogController {

    @Resource
    private OperationLogService operationLogService;

    @GetMapping
    public PageInfo<OperationLog> getOperationLogs(OperationLogQuery query) {
        if (query == null) {
            throw new IllegalArgumentException("查询参数不能为 null");
        }

        // 打印接收到的查询参数
        System.out.println("接收到的查询参数: " + query);

        // 使用 PageHelper 开启分页
        PageHelper.startPage(query.getPage(), query.getLimit());

        // 获取分页操作日志
        List<OperationLog> logs = operationLogService.getLogsWithPagination(query);

        // 创建 PageInfo 对象
        PageInfo<OperationLog> pageInfo = new PageInfo<>(logs);

        // 获取总记录数
        long totalRecords = operationLogService.getTotalLogCount(query);
        pageInfo.setTotal(totalRecords);

        return pageInfo;
    }
}
