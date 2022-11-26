package com.example.elemeapi.service.impl;

import com.example.elemeapi.entity.Orders;
import com.example.elemeapi.mapper.OrdersMapper;
import com.example.elemeapi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public int createOrders(Orders orders) {
        return ordersMapper.createOrders(orders);
    }

    @Override
    public int pay(Long orderId) {
        return ordersMapper.pay(orderId);
    }

    @Override
    public List<Map<String, Orders>> findOrdersByUserId(Long userId) {
        return ordersMapper.findOrdersByUserId(userId);
    }
}
