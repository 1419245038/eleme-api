package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.Business;
import com.example.elemeapi.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 商家模块
 */
@Mapper
public interface BusinessMapper {

    /**
     * 获取全部商家列表
     * @return
     */
    List<Business> getAllBusiness();

    /**
     * 通过商家ID获取商家销售的食品
     * @param businessId
     * @return
     */
    List<Food> getFoodByBusinessId(Long businessId);

    /**
     * 通过id获取对应的商家信息
     * @param businessId
     * @return
     */
    Business getBusinessById(Long businessId);
}
