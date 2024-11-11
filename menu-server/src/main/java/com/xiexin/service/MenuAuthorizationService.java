package com.xiexin.service;

import com.xiexin.entity.Menu;
import com.xiexin.mapper.MenuAuthorizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class MenuAuthorizationService {
    @Autowired
    MenuAuthorizationMapper menuAuthorizationMapper;

    public List<Menu> getList() {
        return menuAuthorizationMapper.getList();
    }

    public void editStatus(Menu menu) {
        menu.setApprove_time(LocalDateTime.now());
        menuAuthorizationMapper.editStatus(menu);
    }

    public Map<String, Object> getStatus(Integer id) {
        Menu menu = menuAuthorizationMapper.getStatus(id);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("status",menu.getStatus());
        result.put("proposer",menu.getProposer());
        result.put("propose_time",menu.getPropose_time());
        result.put("approver",menu.getApprover());
        result.put("approve_time",menu.getApprove_time());
        result.put("reason",menu.getReason());
        return result;
    }
}
