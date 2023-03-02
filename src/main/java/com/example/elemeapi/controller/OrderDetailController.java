package com.example.elemeapi.controller;

import com.example.elemeapi.entity.OrderDetail;
import com.example.elemeapi.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping("/create")
    @ResponseBody
    Map<String,Object> create(OrderDetail orderDetail){
        Map<String,Object> result=new HashMap<>();
        int code = orderDetailService.createOrderDetail(orderDetail);
        result.put("code",code);
        result.put("msg","成功");
        return result;
    }

    @RequestMapping("/getDetail")
    @ResponseBody
    Map<String,Object> getDetail(){
        Map<String,Object> result=new HashMap<>();
        List<Map<String, Object>> detail = orderDetailService.findDetailByOrderId();
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",detail);
        return result;
    }

}
