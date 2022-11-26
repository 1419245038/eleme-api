package com.example.elemeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {

    private Long businessId;

    private String businessName;

    private String businessLogo;

    private String businessAddress;

    private BigDecimal businessDeliveryPrice;

    private BigDecimal businessStartPrice;

    private String businessDesc;

    private String businessType;

}
