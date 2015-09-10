package com.psc.eStore.manager;

import com.psc.eStore.dao.UserDao;
import com.psc.eStore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManager {

    @Autowired
    private UserDao userDao;

    public void createUser(User user) throws Exception {
        userDao.createUser(user);
    }

    public User getUser(User user) throws Exception {
        return userDao.getUser(user);
    }

    public User updatePassword(User user) throws Exception {
        return userDao.updatePassword(user);
    }

    public User getUserByKeyValue(String keyValue) throws Exception {
        return userDao.getUserByKeyValue(keyValue);
    }

    public void updatePasswordKey(User user) throws Exception {
        userDao.updatePasswordKey(user);
    }
}