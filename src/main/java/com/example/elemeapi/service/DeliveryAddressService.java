package com.example.elemeapi.service;


import com.example.elemeapi.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {

    /**
     * 通过id获取收货地址
     * @param id
     * @return
     */
    DeliveryAddress getDeliveryAddressById(Long id);

    /**
     * 获取某个用户的全部收货地址
     * @param userId
     * @return
     */
    List<DeliveryAddress> getAllDeliveryAddressByUserId(Long userId);

    /**
     * 获取某个用户的常用收货地址
     * @param userId
     * @return
     */
    DeliveryAddress getUsersCommonlyUsedAddress(Long userId);

    /**
     * 添加收货地址
     * @param address
     * @return
     */
    int addAddress(DeliveryAddress address);

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    int removeAddress(Long addressId);

    /**
     * 修改收货地址
     * @param address
     * @return
     */
    int updateAddress(DeliveryAddress address);
}
