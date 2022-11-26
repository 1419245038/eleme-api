package com.example.elemeapi.service;

import com.example.elemeapi.entity.User;

public interface UserService {

    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 通过token获取用户信息
     * @param token
     * @return
     */
    User findUserByToken(String token);

    /**
     * 注销登录
     * @param token
     * @return
     */
    boolean logout(String token);

}
