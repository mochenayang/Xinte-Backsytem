package com.xiexin.service;

import com.xiexin.dto.LoginLogQuery;
import com.xiexin.entity.LoginLog;
import com.xiexin.mapper.LoginLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    //保存日志
    public void saveLoginLog(LoginLog loginLog) {
        loginLogMapper.insertLoginLog(loginLog);
    }

    // 获取分页登录日志
    public List<LoginLog> getLogsWithPagination(LoginLogQuery query) {
        int offset = (query.getPage() - 1) * query.getLimit();
        System.out.println("Offset: " + offset + ", Limit: " + query.getLimit());
        return loginLogMapper.getLogsWithPagination(query.getUsername(), query.getIp(), query.getStatus(), query.getStartDate(), query.getEndDate(), offset, query.getLimit());
    }

    //获取总记录数
    public long getTotalLogCount(LoginLogQuery query) {
        return loginLogMapper.getTotalLogCount(query.getUsername(),
                query.getIp(),
                query.getStatus(),
                query.getStartDate(),
                query.getEndDate());
    }

}
