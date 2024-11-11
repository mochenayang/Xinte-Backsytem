package com.xiexin.utils;

import com.xiexin.entity.Dept;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildChildrenUtils {
    public List<Dept> buildChildren(int parentId, List<Dept> deptList) {
        List<Dept> children = new ArrayList<>();
        deptList.forEach(e -> {
            if (e.getParent_id() == parentId) {
                e.setChildren(buildChildren(e.getId(), deptList));
                children.add(e);
            }
        });
        return children;
    }

    public String getParentsIds(int parentId,   List<Dept> deptList){
        StringBuilder resultBuilder = new StringBuilder();

        deptList.forEach(e -> {
            if (e.getId() == parentId) {
                if (!e.getParents_id().isEmpty()&&!e.getParents_id().equals("-1")) {
                    resultBuilder.append(e.getParents_id()).append(",");
                }
                resultBuilder.append(parentId);
            }
        });

        return resultBuilder.toString();
    }
}
