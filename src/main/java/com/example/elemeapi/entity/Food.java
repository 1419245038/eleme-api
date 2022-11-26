package com.example.elemeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    private Long foodId;

    private String foodName;

    private String foodPic;

    private String foodType;

    private BigDecimal foodPrice;

    private String foodDesc;

    private Long businessId;
}
