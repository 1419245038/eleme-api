package com.example.elemeapi.service.impl;

import com.example.elemeapi.entity.Business;
import com.example.elemeapi.entity.Food;
import com.example.elemeapi.service.BusinessService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BusinessServiceImplTest {

    @Autowired
    BusinessService businessService;

    @Test
    void getAllBusiness() {
        List<Business> business = businessService.getAllBusiness();
        System.out.println(business);
    }

    @Test
    void getFoodByBusinessId() {
        List<Food> foodList = businessService.getFoodByBusinessId(1l);
        System.out.println(foodList);
    }

    @Test
    void testGetAllBusiness() {

    }
}