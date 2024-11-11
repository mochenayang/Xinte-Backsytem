package com.xiexin.mapper;

import com.xiexin.entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM dept")
    List<Dept> getList();

    @Insert("INSERT INTO dept(name,parent_id,parents_id) VALUES (#{name},#{parent_id},#{parents_id})")
    void addList(Dept dept);

    @Update("UPDATE dept SET name=#{name} WHERE id=#{id}")
    void editList(Dept dept);

    void deleteList(List<Integer> ids);
}