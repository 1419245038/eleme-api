package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersMapper {

    int createOrders(Orders orders);

    int pay(Long orderId);

    List<Map<String,Orders>> findOrdersByUserId(Long userId);
}
