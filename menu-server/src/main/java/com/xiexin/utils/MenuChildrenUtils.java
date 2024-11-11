package com.xiexin.utils;

import com.xiexin.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuChildrenUtils {
    public List<Menu> buildChildren(int parentId, List<Menu> deptList) {
        List<Menu> children = new ArrayList<>();
        deptList.forEach(e -> {
            if (e.getParent_id() == parentId) {
                e.setChildren(buildChildren(e.getMenuId(), deptList));
                children.add(e);
            }
        });
        return children;
    }

    public String getParentsIds(int parentId,   List<Menu> deptList){
        StringBuilder resultBuilder = new StringBuilder();

        deptList.forEach(e -> {
            if (e.getMenuId() == parentId) {
                if (!e.getParents_id().isEmpty()&&!e.getParents_id().equals("-1")) {
                    resultBuilder.append(e.getParents_id()).append(",");
                }
                resultBuilder.append(parentId);
            }
        });


        return resultBuilder.toString();
    }
}
