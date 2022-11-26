package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface CartMapper {

    int addFoodToCart(Cart cart);

    int updateFoodNum(Cart cart);

    int removeFoodFromCart(Cart cart);

    int clear(Cart cart);

    List<Map<String,Object>> getTotalFoodNumByUserId(Long userId);

    List<Map<String,Object>> getTotalFoodPriceByUserId(Long userId);

    List<Map<String,Object>> getFoodNum(Cart cart);

    List<Map<String,Object>> getFoodList(Cart cart);

}
