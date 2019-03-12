package com.phonecounter.server.service;

import com.phonecounter.server.dao.UserDao;
import com.phonecounter.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer login(User user) {
        User res = userDao.login(user);
        if (res != null && res.getId() != null) {
            return res.getId();
        }
        return null;
    }

    public boolean register(User user) {
        return userDao.register(user);
    }

}
