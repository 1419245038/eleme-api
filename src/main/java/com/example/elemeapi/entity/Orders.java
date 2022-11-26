package com.example.elemeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    private Long orderId;

    private Long userId;

    private Long businessId;

    private Long deliveryaddressId;

    private BigDecimal orderTotalPrice;

    private BigDecimal deliveryPrice;

    private Integer orderStats;

    private Date date;
}
