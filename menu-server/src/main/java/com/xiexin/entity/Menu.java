package com.xiexin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Integer menuId;
    private String menuName;
    private String icon;
    private String menu_type;
    private String path;
    private String file_path;
    private String roles;
    private String link_type;
    private String out_type;
    private LocalDateTime create_time;
    private LocalDateTime last_time;
    private Integer parent_id;
    private String parents_id;
    private String status;
    private String children_ids;
    private String reason;
    private String proposer;
    private LocalDateTime propose_time;
    private String approver;
    private LocalDateTime approve_time;
    private List<Menu> children;
}

