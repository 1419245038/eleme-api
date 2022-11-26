package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.Business;
import com.example.elemeapi.entity.Food;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class BusinessMapperTest {

    @Autowired
    BusinessMapper businessMapper;

    @Test
    void getAllBusiness() {
        List<Business> business = businessMapper.getAllBusiness();
        System.out.println(business);
    }

    @Test
    void getFoodByBusinessId() {
        List<Food> foodList = businessMapper.getFoodByBusinessId(1l);
        System.out.println(foodList);

    }

    @Test
    void getBusinessById() {
        Business business = businessMapper.getBusinessById(1l);
        System.out.println(business);
    }
}