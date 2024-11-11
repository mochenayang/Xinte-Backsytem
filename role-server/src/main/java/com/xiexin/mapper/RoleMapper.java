package com.xiexin.mapper;

import com.xiexin.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> getRoleList(Integer start, Integer pageSize);

    @Insert("INSERT INTO role(name, tag, descript, menuroles, create_time, last_time) " +
            "VALUES (#{name},#{tag},#{descript},#{menuroles},#{create_time},#{last_time})")
    void addRoleList(Role role);

    void deleteByIds(List<Integer> role_ids);

    void updateById(Role role);

    @Select("SELECT count(*) from role")
    Integer count();
}
