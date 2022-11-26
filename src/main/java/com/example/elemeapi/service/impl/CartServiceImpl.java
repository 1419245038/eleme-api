package com.example.elemeapi.service.impl;

import com.example.elemeapi.entity.Cart;
import com.example.elemeapi.entity.Food;
import com.example.elemeapi.mapper.CartMapper;
import com.example.elemeapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public int addFoodToCart(Cart cart) {
        return cartMapper.addFoodToCart(cart);
    }

    @Override
    public int updateFoodNum(Cart cart) {
        return cartMapper.updateFoodNum(cart);
    }

    @Override
    public int removeFoodFromCart(Cart cart) {
        return cartMapper.removeFoodFromCart(cart);
    }

    @Override
    public int clear(Cart cart) {
        return cartMapper.clear(cart);
    }

    @Override
    public List<Map<String, Object>> getTotalFoodNumByUserId(Long userId) {
        return cartMapper.getTotalFoodNumByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> getTotalFoodPriceByUserId(Long userId) {
        return cartMapper.getTotalFoodPriceByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> getFoodNum(Cart cart) {
        return cartMapper.getFoodNum(cart);
    }

    @Override
    public List<Map<String, Object>> getFoodList(Cart cart) {
        return cartMapper.getFoodList(cart);
    }
}
