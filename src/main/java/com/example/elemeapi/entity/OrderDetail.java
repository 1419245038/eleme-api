package com.example.elemeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    private Long orderdetailId;

    private Long orderId;

    private Long foodId;

    private String foodName;

    private String foodType;

    private BigDecimal foodTotalPrice;

    private Integer foodNum;
}
