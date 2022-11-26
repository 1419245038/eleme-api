package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.DeliveryAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper {

    /**
     * 通过id获取收货地址
     * @param id
     * @return
     */
    DeliveryAddress getDeliveryAddressById(Long id);

    /**
     * 获取用户的所有收货地址
     * @param userId
     * @return
     */
    List<DeliveryAddress> getUsersAllAddressByUserId(Long userId);

    /**
     * 获取某个用户的常用收货地址
     * @param userId
     * @return
     */
    DeliveryAddress getUsersCommonlyUsedAddress(Long userId);

    /**
     * 移除某个用户的常用收货地址
     * @param userId
     * @return
     */
    int removeUsersCommonlyUsedAddress(Long userId);

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
