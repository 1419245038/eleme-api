package com.example.elemeapi.service.impl;

import com.example.elemeapi.entity.OrderDetail;
import com.example.elemeapi.mapper.OrderDetailMapper;
import com.example.elemeapi.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public int createOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.createOrderDetail(orderDetail);
    }

    @Override
    public List<Map<String, Object>> findDetailByOrderId() {
        return orderDetailMapper.findDetailByOrderId();
    }
}
