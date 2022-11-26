package com.example.elemeapi.service.impl;

import com.example.elemeapi.entity.DeliveryAddress;
import com.example.elemeapi.mapper.DeliveryAddressMapper;
import com.example.elemeapi.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    @Autowired
    DeliveryAddressMapper addressMapper;


    @Override
    public DeliveryAddress getDeliveryAddressById(Long id) {
        return addressMapper.getDeliveryAddressById(id);
    }

    @Override
    public List<DeliveryAddress> getAllDeliveryAddressByUserId(Long userId) {
        return addressMapper.getUsersAllAddressByUserId(userId);
    }

    @Override
    public DeliveryAddress getUsersCommonlyUsedAddress(Long userId) {
        return addressMapper.getUsersCommonlyUsedAddress(userId);
    }

    @Override
    public int addAddress(DeliveryAddress address) {
        if (address.getCommonlyUsed()==1){
            DeliveryAddress commonlyUsedAddress = addressMapper.getUsersCommonlyUsedAddress(address.getUserId());
            if (commonlyUsedAddress!=null){
                addressMapper.removeUsersCommonlyUsedAddress(address.getUserId());
            }
        }
        return addressMapper.addAddress(address);
    }

    @Override
    public int removeAddress(Long addressId) {
        return addressMapper.removeAddress(addressId);
    }

    @Override
    public int updateAddress(DeliveryAddress address) {
        if (address.getCommonlyUsed()==1){
            DeliveryAddress commonlyUsedAddress = addressMapper.getUsersCommonlyUsedAddress(address.getUserId());
            if (commonlyUsedAddress!=null){
                addressMapper.removeUsersCommonlyUsedAddress(address.getUserId());
            }
        }
        return addressMapper.updateAddress(address);
    }
}
