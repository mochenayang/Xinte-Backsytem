package com.xiexin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private String tag;
    private String descript;
    private LocalDateTime create_time;
    private LocalDateTime last_time;
    private String menuroles;
    private List<Integer> menuList;
}
