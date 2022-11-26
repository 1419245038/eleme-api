package com.example.elemeapi.service.impl;

import com.example.elemeapi.entity.User;
import com.example.elemeapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void register() {
        User user=new User();
        user.setUsername("13555555555");
        user.setPassword("test123");
        user.setSex(1);
        user.setDate(new Date());
        userService.register(user);
    }

    @Test
    void login() {
        String token = userService.login("13464625092", "test123");
        System.out.println(token);
    }

    @Test
    void findUserByToken() {
        User user = userService.findUserByToken(null);
        System.out.println(user);
    }
}