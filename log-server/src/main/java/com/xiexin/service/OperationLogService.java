package com.xiexin.service;

import com.xiexin.dto.OperationLogQuery;
import com.xiexin.entity.OperationLog;
import com.xiexin.mapper.OperationLogMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class OperationLogService {

    @Resource
    private OperationLogMapper operationLogMapper;



    public List<OperationLog> getLogsWithPagination(OperationLogQuery query) {
        int offset = (query.getPage() - 1) * query.getLimit();
        return operationLogMapper.getLogsWithPagination(
                query.getOperator(),
                query.getPlatform(),
                query.getModule(),
                query.getContent(),
                query.getStartDate(),
                query.getEndDate(),
                offset,
                query.getLimit()
        );
    }

    public long getTotalLogCount(OperationLogQuery query) {
        return operationLogMapper.getTotalLogCount(
                query.getOperator(),
                query.getPlatform(),
                query.getModule(),
                query.getContent(),
                query.getStartDate(),
                query.getEndDate()
        );
    }
}