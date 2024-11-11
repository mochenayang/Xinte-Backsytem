package com.xiexin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private int id;
    private String name;
    private int parent_id;
    private String parents_id;
    private List<Dept> children = new ArrayList<Dept>();

    public Dept(int id,String name,int parent_id,String parents_id){
        super();
        this.id = id;
        this.name = name;
        this.parent_id = parent_id;
        this.parents_id = parents_id;
    }
}
