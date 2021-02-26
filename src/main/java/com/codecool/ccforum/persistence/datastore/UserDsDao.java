package com.codecool.ccforum.persistence.datastore;

import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.entities.User;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;

public class UserDsDao implements UserDao {
    @Override
    public User findById(long id) {
        return ObjectifyService.ofy().load().key(Key.create(User.class, id)).now();
    }

    @Override
    public User findByEmail(String email) {
        List<User> users = ObjectifyService.ofy().load().type(User.class).filter("email", email).list();
        if (users.size() < 1) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void createUser(User user) {
        ObjectifyService.ofy().save().entity(user).now();
    }
}
