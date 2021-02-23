package com.codecool.ccforum.application;

import com.codecool.ccforum.domain.entities.User;
import com.codecool.ccforum.domain.services.UserService;
import com.codecool.ccforum.ui.spi.UsersSpi;

public class UsersSpiImpl implements UsersSpi {

    private final UserService userService;

    public UsersSpiImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public long registerUser(String name, String email, String password) {
        User user = userService.createUser(email, name, password);
        return user.getId();
    }

    @Override
    public Long findUserByEmailPassword(String email, String password) {
        User user = userService.findByEmail(email.trim().toLowerCase());
        if (user == null) {
            return null;
        }
        password = password.trim();
        if (!user.getPasword().equals(password)) {
            return null;
        }

        return user.getId();
    }
}
