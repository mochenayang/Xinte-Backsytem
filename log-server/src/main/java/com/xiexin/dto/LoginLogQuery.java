package com.xiexin.dto;

import java.util.Date;

public class LoginLogQuery {
    private String username;
    private String ip;
    private String status;
    private Date startDate;
    private Date endDate;
    private Integer page = 1;  // 默认页码
    private Integer limit = 5; // 默认每页条数

    // Getter 和 Setter 方法
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
