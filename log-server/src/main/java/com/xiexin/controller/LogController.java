package com.xiexin.controller;

import com.xiexin.entity.LoginLog;
import com.xiexin.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping
    public void recordLoginLog(@RequestBody Map<String, Object> logInfo) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId((Integer) logInfo.get("userId")); // 获取 userId
        loginLog.setUsername((String) logInfo.get("username"));
        loginLog.setIp((String) logInfo.get("ip"));
        loginLog.setTimestamp((Date) logInfo.get("timestamp"));
        loginLog.setStatus((String) logInfo.get("status"));
        loginLog.setAddress((String) logInfo.get("address")); // 新增地址

        loginLogService.saveLoginLog(loginLog);
    }
}
