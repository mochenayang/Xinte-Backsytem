package com.xiexin.mapper;

import com.xiexin.entity.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface MenuMapper {
    @Select("SELECT * FROM menulist")
    List<Menu> getAll();

    @Insert("INSERT INTO menulist(menuName, icon, menu_type, path, file_path," +
            " roles, link_type, out_type, create_time, last_time, parent_id," +
            " parents_id, status, children_ids) VALUES (#{menuName},#{icon},#{menu_type}," +
            " #{path},#{file_path},#{roles},#{link_type},#{out_type},#{create_time}, " +
            " #{last_time},#{parent_id},#{parents_id},#{status},#{children_ids})")
    void addMenuList(Menu menu);

    void deleteMenuList(List<Integer> ids);

    void editMenuList(Menu menu);
}
