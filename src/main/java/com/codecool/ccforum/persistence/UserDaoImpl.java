package com.codecool.ccforum.persistence;

import com.codecool.ccforum.persistence.BaseDao;
import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.entities.User;

import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public User findById(long id) {
        return new User(id, "asdf@asdf.hu", "Kiss Pista", "sadfasdf");
    }

    @Override
    public User findByEmail(String email) {
        return new User(1, "asdf@asdf.hu", "Kiss Pista", "sadfasdf");
    }

    @Override
    public void createUser(User user) {

    }
}
