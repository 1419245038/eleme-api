package com.example.elemeapi.mapper;


import com.example.elemeapi.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDetailMapper {

    int createOrderDetail(OrderDetail orderDetail);

    List<Map<String,Object>> findDetailByOrderId();

}
