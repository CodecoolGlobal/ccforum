package com.codecool.ccforum.domain.services;

import com.codecool.ccforum.domain.BaseTestDao;
import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.entities.User;

import java.util.List;

public class UserDaoTestImpl extends BaseTestDao<User> implements UserDao {
    @Override
    public User findByEmail(String email) {
        List<User> res = find((e) -> e.getEmail().equals(email));
        if (res.size() > 0) {
            return res.get(0);
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        this.save(user);
    }
}
