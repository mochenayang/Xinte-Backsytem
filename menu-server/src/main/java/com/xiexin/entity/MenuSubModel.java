package com.xiexin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuSubModel {
    private Integer id;
    private String label;
    private String attr;
    private Integer checkedData;
    private Integer parent_id;
}

