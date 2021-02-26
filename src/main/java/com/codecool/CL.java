package com.codecool;

import com.codecool.ccforum.domain.entities.Comment;
import com.codecool.ccforum.domain.entities.Thread;
import com.codecool.ccforum.domain.entities.User;
import com.codecool.ccforum.ui.spi.Session;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CL implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ObjectifyService.register(User.class);
        ObjectifyService.register(Thread.class);
        ObjectifyService.register(Comment.class);
        ObjectifyService.register(Session.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // never called
    }
}
