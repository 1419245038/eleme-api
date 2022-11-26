package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailMapperTest {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Test
    void createOrderDetail() {
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setFoodTotalPrice(BigDecimal.TEN);
        orderDetail.setFoodId(1l);
        orderDetail.setOrderId(13l);
        orderDetail.setFoodName("1");
        orderDetail.setFoodNum(1);
        orderDetail.setFoodType("1");
        orderDetailMapper.createOrderDetail(orderDetail);
    }

    @Test
    void findDetailByOrderId() {
        List<Map<String, Object>> detail = orderDetailMapper.findDetailByOrderId();
        System.out.println(detail);
    }
}