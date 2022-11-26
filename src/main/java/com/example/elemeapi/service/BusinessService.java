package com.example.elemeapi.service;

import com.example.elemeapi.entity.Business;
import com.example.elemeapi.entity.Food;

import java.util.List;

public interface BusinessService {

    /**
     * 获取全部商家信息
     * @return
     */
    List<Business> getAllBusiness();

    /**
     * 通过商家id获取商家的餐品信息
     * @param businessId
     * @return
     */
    List<Food> getFoodByBusinessId(Long businessId);

    /**
     * 通过商家id获取某个商家信息
     * @param businessId
     * @return
     */
    Business findBusinessById(Long businessId);
}
