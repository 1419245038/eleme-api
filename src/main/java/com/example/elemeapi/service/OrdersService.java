package com.example.elemeapi.service;

import com.example.elemeapi.entity.Orders;

import java.util.List;
import java.util.Map;

public interface OrdersService {

    /**
     * 创建订单
     * @param orders
     * @return
     */
    int createOrders(Orders orders);

    /**
     * 修改订单状态为已支付
     * @param orderId
     * @return
     */
    int pay(Long orderId);

    /**
     * 获取用户的订单信息
     * @param userId
     * @return
     */
    List<Map<String,Orders>> findOrdersByUserId(Long userId);
}
