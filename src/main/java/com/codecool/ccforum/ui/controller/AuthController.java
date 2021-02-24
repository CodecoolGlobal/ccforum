package com.codecool.ccforum.ui.controller;

import com.codecool.ccforum.ui.spi.Session;
import com.codecool.ccforum.ui.spi.SessionDao;
import com.codecool.ccforum.ui.spi.UsersSpi;
import com.google.inject.Inject;

public class AuthController {

    private final UsersSpi usersSpi;
    private final SessionDao sessionDao;

    @Inject
    public AuthController(UsersSpi usersSpi, SessionDao sessionDao) {
        this.usersSpi = usersSpi;
        this.sessionDao = sessionDao;
    }

    public void onRegister(String name, String email, String password) {
        usersSpi.registerUser(name, email, password);
    }

    public Long onLogin(String email, String password) {
        Long userId = usersSpi.findUserByEmailPassword(email, password);
        if (userId == null) {
            return null;
        }

        Session ss =sessionDao.createSession(userId);
        return ss.getId();
    }

}
