package com.codecool.ccforum.domain.services;

import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.entities.User;
import com.google.inject.Inject;

public class UserService {

    private final UserDao userDao;

    @Inject
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findById(long id) {
        return userDao.findById(id);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User createUser(String email, String name, String password) {
        if (email == null) {
            throw new NullPointerException();
        }
        if (name == null) {
            throw new NullPointerException();
        }
        if (password == null) {
            throw new NullPointerException();
        }

        User user = new User(email, name, password);
        userDao.createUser(user);

        return user;
    }

}
