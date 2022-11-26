package com.example.elemeapi.service.impl;

import com.example.elemeapi.entity.Business;
import com.example.elemeapi.entity.Food;
import com.example.elemeapi.mapper.BusinessMapper;
import com.example.elemeapi.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper businessMapper;


    @Override
    public List<Business> getAllBusiness() {
        return businessMapper.getAllBusiness();
    }

    @Override
    public List<Food> getFoodByBusinessId(Long businessId) {
        return businessMapper.getFoodByBusinessId(businessId);
    }

    @Override
    public Business findBusinessById(Long businessId) {
        return businessMapper.getBusinessById(businessId);
    }
}
