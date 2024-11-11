package com.xiexin.service;

import com.xiexin.entity.Dept;
import com.xiexin.mapper.DeptMapper;
import com.xiexin.utils.BuildChildrenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    BuildChildrenUtils buildChildrenUtils;

    public List<Dept> getDeptList() {
        List<Dept> all = getAllList();
//        System.out.println(all);

        List<Dept> result = new ArrayList<>();
        all.forEach(e -> {
            if (e.getParent_id() == -1) {
                e.setChildren(buildChildrenUtils.buildChildren(e.getId(), all));
                result.add(e);
//                System.out.println(result);
            }
        });

        return result;
    }

    public void addDept(Dept dept) {
        System.out.println(buildChildrenUtils.getParentsIds(dept.getParent_id(), getAllList()));
        dept.setParents_id(buildChildrenUtils.getParentsIds(dept.getParent_id(), getAllList()));
        deptMapper.addList(dept);
    }

    public List<Dept> getAllList(){
        return deptMapper.getList();
    }

    public void editDept(Dept dept) {
        deptMapper.editList(dept);
    }

    public void deleteDept(Dept dept) {
        List<Dept> all = getAllList();
        List<Integer> ids = new ArrayList<>();
        ids.add(dept.getId());
        all.forEach(e -> {
            String[] elements = e.getParents_id().split(",");
            for (String element : elements) {
                if (element.equals(dept.getId() + "")) {
                    ids.add(e.getId());
                }
            }
        });
        System.out.println(ids);
        deptMapper.deleteList(ids);
    }
}
