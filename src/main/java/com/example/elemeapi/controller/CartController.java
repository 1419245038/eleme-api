package com.example.elemeapi.controller;

import com.example.elemeapi.entity.Cart;
import com.example.elemeapi.entity.Food;
import com.example.elemeapi.entity.User;
import com.example.elemeapi.service.CartService;
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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("/add")
    @ResponseBody
    Map<String,Object> add(Cart cart){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        Integer foodNum = cart.getFoodNum();
        cart.setUserId(user.getUserId());
        cart.setDatetime(new Date());
        if(foodNum==1){
            int code = cartService.addFoodToCart(cart);
            result.put("code",code);
            result.put("msg","加购成功");
        }else if(foodNum>1){
            int code = cartService.updateFoodNum(cart);
            result.put("code",code);
            result.put("msg","更新数量成功");
        }
        return result;
    }

    @RequestMapping("/sub")
    @ResponseBody
    Map<String,Object> sub(Cart cart){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        Integer foodNum = cart.getFoodNum();
        cart.setUserId(user.getUserId());
        cart.setDatetime(new Date());
        if (foodNum==0){
            int code = cartService.removeFoodFromCart(cart);
            result.put("code",code);
            result.put("msg","移除成功");
        }else {
            int code = cartService.updateFoodNum(cart);
            result.put("code",code);
            result.put("msg","更新数量成功");
        }
        return  result;
    }

    @RequestMapping("getTotalNum")
    @ResponseBody
    Map<String,Object> getTotal(){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        List<Map<String, Object>> num = cartService.getTotalFoodNumByUserId(user.getUserId());
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",num);
        return  result;
    }

    @RequestMapping("getTotalPrice")
    @ResponseBody
    Map<String,Object> getTotalPrice(){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        List<Map<String, Object>> price = cartService.getTotalFoodPriceByUserId(user.getUserId());
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",price);
        return  result;
    }

    @RequestMapping("getFoodNum")
    @ResponseBody
    Map<String,Object> getFoodNum(Cart cart){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        cart.setUserId(user.getUserId());
        List<Map<String, Object>> foodNum = cartService.getFoodNum(cart);
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",foodNum);
        return result;
    }

    @RequestMapping("getFoodList")
    @ResponseBody
    Map<String,Object> getFoodList(Cart cart){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        cart.setUserId(user.getUserId());
        List<Map<String, Object>> foodList = cartService.getFoodList(cart);
        result.put("code",0);
        result.put("msg","成功");
        result.put("data",foodList);
        return result;
    }

    @RequestMapping("clear")
    @ResponseBody
    Map<String,Object> clear(Cart cart){
        Map<String,Object> result=new HashMap<>();
        User user = UserThreadLocal.get();
        cart.setUserId(user.getUserId());
        int code = cartService.clear(cart);
        result.put("code",code);
        result.put("msg","成功");
        return result;
    }
}
