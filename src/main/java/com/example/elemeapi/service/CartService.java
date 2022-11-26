package com.example.elemeapi.service;

import com.example.elemeapi.entity.Cart;
import com.example.elemeapi.entity.Food;

import java.util.List;
import java.util.Map;

public interface CartService {



    /**
     * 加入食品到购物车
     * @param cart
     * @return
     */
    int addFoodToCart(Cart cart);

    /**
     * 更新购物车中食品的数量
     * @param cart
     * @return
     */
    int updateFoodNum(Cart cart);

    /**
     * 把食品从购物车中移除
     * @param cart
     * @return
     */
    int removeFoodFromCart(Cart cart);

    /**
     * 清空用户在某个商家中的购物车
     * @param cart
     * @return
     */
    int clear(Cart cart);

    /**
     * 获取某个用户加入到购物车
     * 中的食品总数
     * @param userId
     * @return
     */
    List<Map<String,Object>> getTotalFoodNumByUserId(Long userId);

    /**
     * 获取某个用户加入到购物车
     * 中的食品总价
     * @param userId
     * @return
     */
    List<Map<String,Object>> getTotalFoodPriceByUserId(Long userId);

    /**
     * 获取个用户在某个商家中
     * 加入到购物车中的每种食品
     * 的数量
     * @param cart
     * @return
     */
    List<Map<String,Object>> getFoodNum(Cart cart);

    /**
     * 获取个用户在某个商家中
     * 加入到购物车中的每种食品
     * 的详细信息
     * @param cart
     * @return
     */
    List<Map<String,Object>> getFoodList(Cart cart);
}
