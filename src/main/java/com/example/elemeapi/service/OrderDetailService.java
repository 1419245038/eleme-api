package com.example.elemeapi.service;

import com.example.elemeapi.entity.OrderDetail;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {

    /**
     * 创建详细订单
     * @param orderDetail
     * @return
     */
    int createOrderDetail(OrderDetail orderDetail);

    List<Map<String,Object>> findDetailByOrderId();
}
