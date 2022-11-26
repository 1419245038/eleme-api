package com.example.elemeapi.mapper;

import com.example.elemeapi.entity.DeliveryAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DeliveryAddressMapperTest {

    @Autowired
    DeliveryAddressMapper addressMapper;

    @Test
    void getUsersAllAddressByUserId() {
        List<DeliveryAddress> address = addressMapper.getUsersAllAddressByUserId(1l);
        System.out.println(address);
    }

    @Test
    void getUsersCommonlyUsedAddress() {
        DeliveryAddress usedAddress = addressMapper.getUsersCommonlyUsedAddress(1l);
        System.out.println(usedAddress);
    }

    @Test
    void addAddress() {
        DeliveryAddress address=new DeliveryAddress();
        address.setUserId(1l);
        address.setContactsName("朱彭贺");
        address.setContactsPhoneNum("13464625092");
        address.setDeliveryaddress("沈北新区道义镇鸿源家园5号楼");
        address.setCommonlyUsed(0);
        addressMapper.addAddress(address);
    }

    @Test
    void removeAddress() {
        addressMapper.removeAddress(4l);
    }

    @Test
    void updateAddress() {
        DeliveryAddress address = addressMapper.getUsersCommonlyUsedAddress(1l);
        address.setContactsPhoneNum("18904055092");
        addressMapper.updateAddress(address);
    }

    @Test
    void getDeliveryAddressById() {
        DeliveryAddress address = addressMapper.getDeliveryAddressById(1l);
        System.out.println(address);
    }
}