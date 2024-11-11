package com.xiexin.mapper;

import com.xiexin.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username} and password = #{password}")
    User findUser(User user);

    @Insert("INSERT INTO user(username, password ,email,role_id,dept,create_time,edit_time) VALUES (#{username},#{password} ,#{email}, 1,1,#{create_time},#{edit_time})")
    void insertUser(User user);

    List<User> page(List<Integer> ids, Integer start, Integer pageSize);

    Integer count(List<Integer> ids);

    @Insert("INSERT INTO user(username, password,name, email, phonenumber, dept, role_id,create_time ,edit_time) " +
            "VALUES (#{username},#{password},#{name},#{email},#{phonenumber},#{dept},#{role_id},#{create_time},#{edit_time})")
    void addUser(User user);

    void deleteByIds(List<Integer> user_ids);

    void updateUser(User user);
}
