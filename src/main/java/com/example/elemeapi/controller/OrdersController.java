package com.example.elemeapi.controller;

import com.example.elemeapi.entity.Orders;
import com.example.elemeapi.entity.User;
import com.example.elemeapi.service.OrdersService;
import com.example.elemeapi.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("/create")
    @ResponseBody
    Map<String,Object> create(Orders orders){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        orders.setUserId(user.getUserId());
        orders.setDate(new Date());
        int code = ordersService.createOrders(orders);
        result.put("code",code);
        result.put("msg","成功");
        result.put("data",orders.getOrderId());
        return result;
    }

    @RequestMapping("/pay")
    @ResponseBody
    Map<String,Object> pay(Long orderId){
        Map<String,Object> result=new HashMap<>();
        int code = ordersService.pay(orderId);
        result.put("code",code);
        result.put("msg","成功");
        return result;
    }

    @RequestMapping("/getOrders")
    @ResponseBody
    Map<String,Object> getOrders(){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        List<Map<String, Orders>> orders = ordersService.findOrdersByUserId(user.getUserId());
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",orders);
        return result;
    }
}
