package com.xiexin.mapper;

import com.xiexin.entity.MenuModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuModelMapper {

    @Select("SELECT children_ids FROM menulist WHERE menuId=#{id}")
    String getChildren(Integer id);

    List<MenuModel> getsubModel(List<Integer> ids);

    @Insert("INSERT INTO model(value) VALUES (#{name})")
    void addMenuModel(String name);
}

