package com.codecool.ccforum.persistence;

import com.codecool.ccforum.persistence.BaseDao;
import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.entities.User;

import java.util.List;
import java.util.Locale;

public class UserDaoImpl extends BaseDao<User> implements UserDao {


    @Override
    public User findByEmail(String email) {
        List<User> users = this.find((u) -> u.getEmail().toLowerCase().equals(email.trim().toLowerCase()));
        if (users.size() < 1) {
            return null;
        }

        return users.get(0);
    }

    @Override
    public void createUser(User user) {
        if (user == null) {
            throw new NullPointerException();
        }
        this.save(user);
    }
}
