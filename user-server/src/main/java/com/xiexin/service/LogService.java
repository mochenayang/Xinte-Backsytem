package com.xiexin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "log-server")
public interface LogService {
    @PostMapping("/logs")
    void recordLoginLog(@RequestBody Map<String, Object> logInfo);
}
