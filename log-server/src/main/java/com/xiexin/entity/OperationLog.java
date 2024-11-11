package com.xiexin.entity;

import java.time.LocalDate;
import java.util.Date;

import java.time.LocalDateTime;

public class OperationLog {
    private Integer id;
    private String operator;
    private String platform;
    private String module;
    private LocalDate timestamp;
    private String result;
    private String content;

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
// getters 和 setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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



    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

