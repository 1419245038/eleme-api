package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void findUserByName() {
        User user = userMapper.findUserByName("13464625092");
        System.out.println(user);
    }

    @Test
    void addUser() {
        User user=new User();
        user.setUsername("13888888888");
        user.setPassword("test123");
        user.setSex(0);
        user.setDate(new Date());
        int i = userMapper.addUser(user);
        System.out.println(i);
    }
}