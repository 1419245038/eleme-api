package com.example.elemeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {

    private Long deliveryaddressId;

    private String contactsName;

    private String contactsPhoneNum;

    private String deliveryaddress;

    private Long userId;

    private Integer commonlyUsed;

    private Integer contactsSex;
}
