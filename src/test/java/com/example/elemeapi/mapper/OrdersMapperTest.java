package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.Orders;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrdersMapperTest {

    @Autowired
    OrdersMapper ordersMapper;

    @Test
    void createOrders() {
        Orders orders=new Orders();
        orders.setUserId(14l);
        orders.setBusinessId(1l);
        orders.setOrderTotalPrice(BigDecimal.ZERO);
        orders.setDeliveryaddressId(42l);
        orders.setDeliveryPrice(BigDecimal.ZERO);
        orders.setDate(new Date());
        ordersMapper.createOrders(orders);
        System.out.println(orders.getOrderId());
    }

    @Test
    void findOrdersByUserId() {
        List<Map<String, Orders>> orders = ordersMapper.findOrdersByUserId(14l);
        System.out.println(orders);
    }
}