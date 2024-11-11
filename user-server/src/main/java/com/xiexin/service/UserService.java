package com.xiexin.service;

import com.xiexin.clients.DeptClient;
import com.xiexin.entity.Dept;
import com.xiexin.entity.User;
import com.xiexin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    DeptClient deptClient;

    public HashMap<String,Object> page(Integer dept_id, Integer page, Integer pageSize) {
        List<Dept> all = deptClient.getAll();
        List<Integer> ids = new ArrayList<>();
        ids.add(dept_id);
        all.forEach(e -> {
            String[] elements = e.getParents_id().split(",");
            for (String element : elements) {
                if (element.equals(dept_id + "")) {
                    ids.add(e.getId());
                }
            }
        });
        Integer start = (page - 1) * pageSize;
        HashMap<String,Object> map = new HashMap<String,Object>();
        System.out.println(ids);
        map.put("data",userMapper.page(ids,start,pageSize));
        map.put("count",userMapper.count(ids));
        return map;
    }

    public String addUser(User user) {
        user.setCreate_time(LocalDateTime.now());
        user.setEdit_time(LocalDateTime.now());
        userMapper.addUser(user);
        return "success";
    }

    public void deleteIds(List<Integer> user_ids) {
        userMapper.deleteByIds(user_ids);
    }

    public void updateUser(User user) {
        user.setEdit_time(LocalDateTime.now());
        userMapper.updateUser(user);
    }
}
