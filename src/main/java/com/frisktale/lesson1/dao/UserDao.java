package com.frisktale.lesson1.dao;

import java.util.List;

import com.frisktale.lesson1.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface UserDao {
    @Select("select * from \"S_A_User\"")
    List<User> getAllUser();

    @Select("select * from \"S_A_User\" where \"S_A_User\".\"Id\"=#{id}")
    User getUserById(int id);
}