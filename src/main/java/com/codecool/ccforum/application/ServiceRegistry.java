package com.codecool.ccforum.application;

import com.codecool.ccforum.domain.services.UserService;
import com.codecool.ccforum.ui.controller.ThreadController;
import com.codecool.ccforum.ui.controller.ThreadListController;
import com.codecool.ccforum.ui.spi.MockThreadSpi;
import com.codecool.ccforum.ui.spi.MockThreadsSpi;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {

    private static final Map<Class<?>, Object> instances = new HashMap<>();

    static {
        instances.put(ThreadListController.class, new ThreadListController(new MockThreadsSpi()));
        instances.put(ThreadController.class, new ThreadController(new MockThreadSpi()));
    }

    public static <T> T getInstance(Class<T> clazz) {
        return (T) instances.get(clazz);
    }

    private ServiceRegistry() {
    }
}
