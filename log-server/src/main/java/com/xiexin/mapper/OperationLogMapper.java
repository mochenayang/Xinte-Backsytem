package com.xiexin.mapper;

import com.xiexin.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OperationLogMapper {

    void insertOperationLog(OperationLog operationLog);

    List<OperationLog> getLogsWithPagination(
            @Param("operator") String operator,
            @Param("platform") String platform,
            @Param("module") String module,
            @Param("content") String content, // 新增内容参数
            @Param("startDate") LocalDate  startDate,
            @Param("endDate") LocalDate endDate,
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    long getTotalLogCount(
            @Param("operator") String operator,
            @Param("platform") String platform,
            @Param("module") String module,
            @Param("content") String content, // 新增内容参数
            @Param("startDate") LocalDate  startDate,
            @Param("endDate") LocalDate  endDate
    );
}
