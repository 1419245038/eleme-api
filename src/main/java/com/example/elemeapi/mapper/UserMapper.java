package com.example.elemeapi.mapper;


import com.example.elemeapi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findUserByName(String username);

    int addUser(User user);
}
