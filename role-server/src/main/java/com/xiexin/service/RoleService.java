package com.xiexin.service;

import com.xiexin.entity.Role;
import com.xiexin.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public Map<String,Object> getRoleList(Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
        List<Role> result = roleMapper.getRoleList(start,pageSize);
        result.forEach( e -> {
            List<Integer> list= new ArrayList<>();
            for (String s : e.getMenuroles().split(",")) {
                list.add(Integer.parseInt(s.trim()));
            }
            e.setMenuList(list);
        });
        Map<String,Object> map = new HashMap<>();
        Integer count = roleMapper.count();
        map.put("data",result);
        map.put("count",count);
        return map;
    }

    public void addRoleList(Role role) {
        role.setCreate_time(LocalDateTime.now());
        role.setLast_time(LocalDateTime.now());

        String result = role.getMenuList().stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        role.setMenuroles(result);
        roleMapper.addRoleList(role);
    }

    public void deleteRoleList(List<Integer> role_ids) {
        roleMapper.deleteByIds(role_ids);
    }

    public void updateRoleList(Role role) {
        role.setLast_time(LocalDateTime.now());

        String result = role.getMenuList().stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        role.setMenuroles(result);

        roleMapper.updateById(role);
    }
}
