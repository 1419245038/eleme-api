package com.example.elemeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private Long cartId;

    private Long businessId;

    private Long foodId;

    private Long userId;

    private Integer foodNum;

    private Date datetime;
}
