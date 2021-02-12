package com.codecool.ccforum.domain.dao;

import com.codecool.ccforum.domain.entities.User;

public interface UserDao {

    public User findById(long id);
    public User findByEmail(String email);
    public void createUser(User user);

}
