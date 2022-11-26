package com.example.elemeapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.elemeapi.entity.User;
import com.example.elemeapi.exception.BussinessException;
import com.example.elemeapi.mapper.UserMapper;
import com.example.elemeapi.service.UserService;
import com.example.elemeapi.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Override
    public int register(User user) {
        if (StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())||user.getSex()==null){
            throw new BussinessException("TE003", "必填项不能为空");
        }
        User userByName = userMapper.findUserByName(user.getUsername());
        if (userByName!=null) {
            throw new BussinessException("UE001", "该用户名已存在");
        }
        user.setUserHeaderPic("/pic/head_pic.jpg");
        user.setDate(new Date());
        return userMapper.addUser(user);
    }

    @Override
    public String login(String username, String password) {
        if (StringUtils.isEmpty(username)){
            throw new BussinessException("TE001", "用户名不能为空");
        }
        if (StringUtils.isEmpty(password)){
            throw new BussinessException("TE001", "密码不能为空");
        }
        User user = userMapper.findUserByName(username);
        if (user==null){
            throw new BussinessException("UE002", "用户不存在");
        }
        if (!password.equals(user.getPassword())){
            throw new BussinessException("UE003", "密码错误");
        }
        String token = JWTUtils.createToken(user.getUserId());
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(user),1, TimeUnit.DAYS);
        return token;
    }

    @Override
    public User findUserByToken(String token) {
        //token合法性校验
        if (StringUtils.isEmpty(token)){
            throw new BussinessException("UE004","token为空");
        }
        Map<String, Object> map = JWTUtils.checkToken(token);
        if (map==null){
            throw new BussinessException("UE005","token不合法");
        }
        String userJson = redisTemplate.opsForValue().get("TOKEN_" + token);
        if (StringUtils.isEmpty(userJson)){
            throw new BussinessException("UE006","token已失效");
        }
        return JSON.parseObject(userJson,User.class);
    }

    @Override
    public boolean logout(String token) {
        return redisTemplate.delete("TOKEN_"+token);
    }
}
