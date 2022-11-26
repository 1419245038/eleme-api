package com.example.elemeapi.controller;


import com.example.elemeapi.entity.User;
import com.example.elemeapi.exception.BussinessException;
import com.example.elemeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    Map<String,Object> login(String username, String password){
        Map<String,Object> result=new HashMap<>();
        try {
            String token=userService.login(username,password);
            result.put("code",0);
            result.put("msg","登录成功");
            result.put("data",token);
        }catch (BussinessException e){
            result.put("code",e.getCode());
            result.put("msg",e.getMessage());
        }catch (Exception e){
            result.put("code",e.getClass().getSimpleName());
            result.put("msg",e.getMessage());
        }
        return result;
    }


    @RequestMapping("/register")
    @ResponseBody
    Map<String,Object> register(User user){
        Map<String,Object> result=new HashMap<>();
        try{
            int code = userService.register(user);
            result.put("code",code);
            result.put("msg","注册成功");
        }catch (BussinessException e){
            result.put("code",e.getCode());
            result.put("msg",e.getMessage());
        }catch (Exception e){
            result.put("code",e.getClass().getSimpleName());
            result.put("msg",e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    Map<String,Object> getUserInfo(@RequestHeader(value = "Authorization",required = false) String token){
        Map<String,Object> result=new HashMap<>();
        try {
            User user = userService.findUserByToken(token);
            result.put("code",0);
            result.put("msg","获取成功");
            result.put("data",user);
        }catch (BussinessException e){
            result.put("code",e.getCode());
            result.put("msg",e.getMessage());
        }catch (Exception e){
            result.put("code",e.getClass().getSimpleName());
            result.put("msg",e.getMessage());
        }
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    Map<String,Object> logout(@RequestHeader(value = "Authorization",required = false) String token){
        Map<String,Object> result=new HashMap<>();
        boolean isLogout = userService.logout(token);
        if (isLogout){
            result.put("code",0);
            result.put("msg","注销成功");
        }else {
            result.put("code",-1);
            result.put("msg","注销失败");
        }
        return result;
    }
}
