package com.codecool.ccforum.application;

import com.codecool.ccforum.domain.dao.CommentDao;
import com.codecool.ccforum.domain.dao.ThreadDao;
import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.services.CommentService;
import com.codecool.ccforum.domain.services.ThreadService;
import com.codecool.ccforum.domain.services.UserService;
import com.codecool.ccforum.persistence.CommentDaoImpl;
import com.codecool.ccforum.persistence.SessionDaoImpl;
import com.codecool.ccforum.persistence.ThreadDaoImpl;
import com.codecool.ccforum.persistence.UserDaoImpl;
import com.codecool.ccforum.ui.controller.AuthController;
import com.codecool.ccforum.ui.controller.NewThreadController;
import com.codecool.ccforum.ui.controller.ThreadController;
import com.codecool.ccforum.ui.controller.ThreadListController;
import com.codecool.ccforum.ui.spi.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {

    private static final Map<Class<?>, Object> instances = new HashMap<>();

    static {
        instances.put(UserDao.class, new UserDaoImpl());
        instances.put(ThreadDao.class, new ThreadDaoImpl());
        instances.put(CommentDao.class, new CommentDaoImpl());
        instances.put(SessionDao.class, new SessionDaoImpl());

        instances.put(CommentService.class, new CommentService(getInstance(UserDao.class), getInstance(ThreadDao.class), getInstance(CommentDao.class)));
        instances.put(ThreadService.class, new ThreadService(getInstance(UserDao.class), getInstance(ThreadDao.class)));
        instances.put(UserService.class, new UserService(getInstance(UserDao.class)));

        instances.put(ThreadSpi.class, new ThreadSpiImpl(getInstance(ThreadService.class), getInstance(CommentService.class)));
        instances.put(ThreadsSpi.class, new ThreadsSpiImpl(getInstance(ThreadService.class)));
        instances.put(UsersSpi.class, new UsersSpiImpl(getInstance(UserService.class)));

        instances.put(ThreadListController.class, new ThreadListController(getInstance(ThreadsSpi.class)));
        instances.put(ThreadController.class, new ThreadController(getInstance(ThreadSpi.class)));
        instances.put(NewThreadController.class, new NewThreadController(getInstance(ThreadsSpi.class)));
        instances.put(AuthController.class, new AuthController(getInstance(UsersSpi.class), getInstance(SessionDao.class)));


    }

    public static <T> T getInstance(Class<T> clazz) {
        return (T) instances.get(clazz);
    }

    private ServiceRegistry() {
    }
}
