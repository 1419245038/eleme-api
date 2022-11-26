package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.Cart;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class CartMapperTest {

    @Autowired
    CartMapper cartMapper;


    @Test
    void getTotalFoodNumByUserId() {
        List<Map<String, Object>> foodNumByUserId = cartMapper.getTotalFoodNumByUserId(14l);
        System.out.println(foodNumByUserId);
    }

    @Test
    void getTotalFoodPriceByUserId() {
        List<Map<String, Object>> price = cartMapper.getTotalFoodPriceByUserId(14l);
        System.out.println(price);
    }

    @Test
    void getFoodNum() {
        Cart cart=new Cart();
        cart.setUserId(14l);
        cart.setBusinessId(2l);
        List<Map<String, Object>> foodNum = cartMapper.getFoodNum(cart);
        System.out.println(foodNum);
    }

    @Test
    void getFoodList() {
        Cart cart=new Cart();
        cart.setUserId(14l);
        cart.setBusinessId(2l);
        List<Map<String, Object>> foodList = cartMapper.getFoodList(cart);
        System.out.println(foodList);
    }
}