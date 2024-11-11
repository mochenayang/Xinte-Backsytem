package com.xiexin.service;

import com.xiexin.entity.MenuModel;
import com.xiexin.mapper.MenuModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuModelService {
    @Autowired
    MenuModelMapper menuModelMapper;

    public List<MenuModel> getMenuModel(Integer id) {
        System.out.println(menuModelMapper.getChildren(id));
        if( menuModelMapper.getChildren(id).isEmpty()){
            // 子模型为空
            return new ArrayList<>();
        }else {
            List<Integer> list = new ArrayList<>();
            for (String s : menuModelMapper.getChildren(id).split(",")) {
                list.add(Integer.parseInt(s.trim()));
            }
            System.out.println(getSubModel(list));
            return getSubModel(list);
        }
    }

    public List<MenuModel> getSubModel(List<Integer> ids){
        return menuModelMapper.getsubModel(ids);
    }

    public void addMenuModel(String name) {
        menuModelMapper.addMenuModel(name);
    }
}

