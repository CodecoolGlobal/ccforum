package com.codecool.ccforum.domain.services;

import com.codecool.ccforum.domain.entities.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void testFindByExistingId() {
        UserService userService = new UserService(new UserDaoTestImpl());

        User user = userService.createUser("asd@qwe.com", "Oriza Triznyak", "almafa");

        User res = userService.findById(user.getId());
        assertNotNull(res);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateUserWithNullEmail() {
        UserService userService = new UserService(new UserDaoTestImpl());

        userService.createUser(null, "Kiss Pista", "adff");
    }

}
