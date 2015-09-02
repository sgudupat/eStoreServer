package com.psc.eStore.service;

import com.psc.eStore.domain.UserAddress;
import com.psc.eStore.manager.UserAddressManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserAddressService {

    @Autowired
    UserAddressManager userAddressManager;

    public List<UserAddress> getAddress(String userName) {
        return userAddressManager.getAddress(userName);
    }

    public void addAddress(UserAddress userAddress) throws Exception {
        userAddressManager.addAddress(userAddress);
    }

    public void modifyAddress(UserAddress userAddress) throws Exception {
        userAddressManager.modifyAddress(userAddress);
    }

    public void deleteAddress(Long addressId) throws Exception {
        userAddressManager.deleteAddress(addressId);
    }

}