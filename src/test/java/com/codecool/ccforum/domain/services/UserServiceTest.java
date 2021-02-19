package com.codecool.ccforum.domain.services;

import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.entities.User;
import com.codecool.ccforum.persistence.UserDaoImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class UserServiceTest {

//    @Test
//    public void testFindByExistingId() {
//        UserService userService = new UserService(new UserDaoImpl());
//
//        User user = userService.createUser("asd@qwe.com", "Oriza Triznyak", "almafa");
//
//        User res = userService.findById(user.getId());
//        assertNotNull(res);
//    }

    @Test(expected = NullPointerException.class)
    public void testCreateUserWithNullEmail() {
        UserService userService = new UserService(new UserDao() {
            @Override
            public User findById(long id) {
                return null;
            }

            @Override
            public User findByEmail(String email) {
                return null;
            }

            @Override
            public void createUser(User user) {
            }
        });

        userService.createUser(null, "Kiss Pista", "adff");
    }

    @Test
    public void testDaoCreateUserCalled() {
        Map<String, Boolean> props = new HashMap<>();
        UserService userService = new UserService(new UserDao() {
            @Override
            public User findById(long id) {
                return null;
            }

            @Override
            public User findByEmail(String email) {
                return null;
            }

            @Override
            public void createUser(User user) {
                props.put("Dao.createUserCalled", true);
            }
        });

        userService.createUser("asd@qwe.hu", "Kiss Pista", "adff");
        assertNotNull(props.get("Dao.createUserCalled"));
    }

}
