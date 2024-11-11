package com.xiexin.service;


import com.xiexin.entity.Menu;
import com.xiexin.mapper.MenuMapper;
import com.xiexin.utils.MenuChildrenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuChildrenUtils menuChildrenUtils;

    public List<Menu> getMenuList() {
        List<Menu> all = getAllList();

        List<Menu> result = new ArrayList<>();

        all.forEach(e -> {
            if(e.getParent_id() == -1){
                e.setChildren(menuChildrenUtils.buildChildren(e.getMenuId(),all));
                result.add(e);
            }
        });

        return result;
    }

    public List<Menu> getAllList(){
        return menuMapper.getAll();
    }

    public void addMenuList(Menu menu) {
        menu.setCreate_time(LocalDateTime.now());
        menu.setLast_time(LocalDateTime.now());
        if(menu.getMenu_type() == "菜单"){
            menu.setStatus("上架申请待审批");
            menu.setPropose_time(LocalDateTime.now());
        }
        menu.setParents_id(menuChildrenUtils.getParentsIds(menu.getParent_id(),getAllList()));
        menuMapper.addMenuList(menu);
        System.out.println(menu.getParents_id());
    }

    public void deleteMenuList(Integer id) {
        List<Menu> all = getAllList();
        List<Integer> ids = new ArrayList<>();

        ids.add(id);
        all.forEach(e -> {
            String[] elements = e.getParents_id().split(",");
            for (String element : elements) {
                if (element.equals(id + "")) {
                    ids.add(e.getMenuId());
                }
            }
        });
//        System.out.println(ids);
        menuMapper.deleteMenuList(ids);
    }

    public void editMenuList(Menu menu) {
        if (menu.getMenu_type() == "菜单"){
            // 判断
        }
        menu.setLast_time(LocalDateTime.now());
        menu.setParents_id(menuChildrenUtils.getParentsIds(menu.getParent_id(),getAllList()));
        System.out.println(menu.getParents_id());

        menuMapper.editMenuList(menu);
    }
}
