package com.xiexin.mapper;

import com.xiexin.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

import java.util.Date;
import java.util.List;

@Mapper
public interface LoginLogMapper {

    void insertLoginLog(LoginLog loginLog);

    // 添加分页查询
    List<LoginLog> getLogsWithPagination(
            @Param("username") String username,
            @Param("ip") String ip,
            @Param("status") String status,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    long getTotalLogCount(
            @Param("username") String username,
            @Param("ip") String ip,
            @Param("status") String status,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );
}
