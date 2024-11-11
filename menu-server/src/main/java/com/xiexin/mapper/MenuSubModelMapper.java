package com.xiexin.mapper;

import com.xiexin.entity.MenuSubModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuSubModelMapper {

    @Select("SELECT * FROM submodel WHERE parent_id=#{id}")
    List<MenuSubModel> getSubList(Integer id);

    @Insert("INSERT INTO submodel(label, attr, checkedData, parent_id) VALUES (#{label},#{attr},#{checkedData},#{parent_id})")
    void addSubModel(MenuSubModel menuSubModel);

    void updateSubModel(List<Integer> labels);

    void deleteSubModel(List<Integer> ids);
}

