package com.psc.eStore.manager;

import com.psc.eStore.dao.UserAddressDao;
import com.psc.eStore.domain.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserAddressManager {

    @Autowired
    UserAddressDao userAddressDao;

    public List<UserAddress> getAddress(String userName) {
        return userAddressDao.getAddress(userName);

    }

    public void addAddress(UserAddress userAddress) throws Exception {
        userAddressDao.addAddress(userAddress);
    }

    public void modifyAddress(UserAddress userAddress) throws Exception {
        userAddressDao.modifyAddress(userAddress);
    }

    public void deleteAddress(Long addressId) throws Exception {
        userAddressDao.deleteAddress(addressId);
    }

}