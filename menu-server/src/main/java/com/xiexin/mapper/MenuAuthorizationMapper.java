package com.xiexin.mapper;

import com.xiexin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MenuAuthorizationMapper {

    @Select("SELECT * FROM menulist WHERE menu_type='菜单'")
    List<Menu> getList();

    @Update("UPDATE menulist SET status=#{status},reason=#{reason},approver=#{approver},approve_time=#{approve_time} WHERE menuId=#{menuId}")
    void editStatus(Menu menu);

    @Select("SELECT * FROM menulist WHERE menuId=#{id}")
    Menu getStatus(Integer id);
}
