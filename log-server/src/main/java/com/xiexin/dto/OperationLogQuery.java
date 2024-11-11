package com.xiexin.dto;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class OperationLogQuery {
    private String operator; // 操作人
    private String platform; // 操作平台
    private String module;
    @DateTimeFormat(pattern = "yyyy-MM-dd")// 操作模块
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // 结束时间
    private Integer page = 1;  // 默认页码
    private Integer limit = 5;  // 默认每页记录数
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }



    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
