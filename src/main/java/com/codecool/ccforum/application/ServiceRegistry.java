package com.codecool.ccforum.application;

import com.codecool.ccforum.domain.services.CommentService;
import com.codecool.ccforum.domain.services.ThreadService;
import com.codecool.ccforum.domain.services.UserService;
import com.codecool.ccforum.persistence.CommentDaoImpl;
import com.codecool.ccforum.persistence.ThreadDaoImpl;
import com.codecool.ccforum.persistence.UserDaoImpl;
import com.codecool.ccforum.ui.controller.NewThreadController;
import com.codecool.ccforum.ui.controller.ThreadController;
import com.codecool.ccforum.ui.controller.ThreadListController;
import com.codecool.ccforum.ui.spi.MockThreadSpi;
import com.codecool.ccforum.ui.spi.MockThreadsSpi;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {

    private static final Map<Class<?>, Object> instances = new HashMap<>();

    static {
        instances.put(CommentService.class, new CommentService(new UserDaoImpl(), new ThreadDaoImpl(), new CommentDaoImpl()));
        instances.put(ThreadService.class, new ThreadService(new UserDaoImpl(), new ThreadDaoImpl()));
        instances.put(UserService.class, new UserService(new UserDaoImpl()));

        instances.put(ThreadListController.class, new ThreadListController(new ThreadsSpiImpl(getInstance(ThreadService.class))));
        instances.put(ThreadController.class, new ThreadController(new ThreadSpiImpl(getInstance(ThreadService.class), getInstance(CommentService.class))));
        instances.put(NewThreadController.class, new NewThreadController(new ThreadsSpiImpl(getInstance(ThreadService.class))));


    }

    public static <T> T getInstance(Class<T> clazz) {
        return (T) instances.get(clazz);
    }

    private ServiceRegistry() {
    }
}
