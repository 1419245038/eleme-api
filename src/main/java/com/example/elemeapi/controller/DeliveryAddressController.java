package com.example.elemeapi.controller;

import com.example.elemeapi.entity.DeliveryAddress;
import com.example.elemeapi.entity.User;
import com.example.elemeapi.service.DeliveryAddressService;
import com.example.elemeapi.utils.UserThreadLocal;
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
@RequestMapping("/address")
public class DeliveryAddressController {

    @Autowired
    DeliveryAddressService addressService;

    @RequestMapping("/getAll")
    @ResponseBody
    Map<String,Object> getAll(){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        List<DeliveryAddress> addresses = addressService.getAllDeliveryAddressByUserId(user.getUserId());
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",addresses);
        return result;
    }

    @RequestMapping("/getCommonlyUsed")
    @ResponseBody
    Map<String,Object> getCommonlyUsed(){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        DeliveryAddress commonlyUsedAddress = addressService.getUsersCommonlyUsedAddress(user.getUserId());
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",commonlyUsedAddress);
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    Map<String,Object> add(DeliveryAddress address){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        address.setUserId(user.getUserId());
        int code = addressService.addAddress(address);
        result.put("code",code);
        result.put("msg","成功");
        return result;
    }

    @RequestMapping("/remove")
    @ResponseBody
    Map<String,Object> remove(Long addressId){
        Map<String,Object> result=new HashMap<>();
        int code = addressService.removeAddress(addressId);
        result.put("code",code);
        result.put("msg","成功");
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    Map<String,Object> update(DeliveryAddress address){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        address.setUserId(user.getUserId());
        int code = addressService.updateAddress(address);
        result.put("code",code);
        result.put("msg","成功");
        return result;
    }

    @RequestMapping("findById")
    @ResponseBody
    Map<String,Object> findById(Long addressId){
        Map<String,Object> result=new HashMap<>();
        DeliveryAddress address = addressService.getDeliveryAddressById(addressId);
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",address);
        return result;
    }
}
