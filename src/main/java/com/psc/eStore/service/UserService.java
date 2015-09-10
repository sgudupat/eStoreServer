package com.psc.eStore.service;

import com.psc.eStore.domain.User;
import com.psc.eStore.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserManager userManager;

    public void createUser(User user) throws Exception {
        userManager.createUser(user);
    }

    public User getUser(User user) throws Exception {
        return userManager.getUser(user);
    }

    public User getUserByKeyValue(String keyValue) throws Exception {
        return userManager.getUserByKeyValue(keyValue);
    }

    public User updatePassword(User user) throws Exception {
        return userManager.updatePassword(user);
    }

    public void updatePasswordKey(User user) throws Exception {
        userManager.updatePasswordKey(user);
    }
}