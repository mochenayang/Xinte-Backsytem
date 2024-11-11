package com.xiexin.service;

import com.xiexin.entity.MenuSubModel;
import com.xiexin.mapper.MenuSubModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class MenuSubModelService {
    @Autowired
    MenuSubModelMapper menuSubModelMapper;

    public HashMap<String, Object> getSubList(Integer id) {
        System.out.println(menuSubModelMapper.getSubList(id));
        HashMap<String,Object> hashMap = new HashMap<>();

        List<Integer> checkData = new ArrayList<>();
        menuSubModelMapper.getSubList(id).forEach(e -> {
            if (e.getCheckedData()==1){
                checkData.add(e.getId());
            }
        });

        hashMap.put("data", menuSubModelMapper.getSubList(id));
        hashMap.put("checkedData", checkData);

        return hashMap;
    }

    public void addSubModel(MenuSubModel menuSubModel) {
        menuSubModel.setCheckedData(0);
        menuSubModelMapper.addSubModel(menuSubModel);
    }

    public void updateMenuSubModel(List<Integer> labels) {
        menuSubModelMapper.updateSubModel(labels);
        System.out.println(labels);
    }

    public void deleteMenuSubModel(List<Integer> ids) {
        menuSubModelMapper.deleteSubModel(ids);
    }
}
