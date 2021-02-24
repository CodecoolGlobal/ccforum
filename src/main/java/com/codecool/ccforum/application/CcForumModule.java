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
import com.codecool.ccforum.ui.spi.SessionDao;
import com.codecool.ccforum.ui.spi.ThreadSpi;
import com.codecool.ccforum.ui.spi.ThreadsSpi;
import com.codecool.ccforum.ui.spi.UsersSpi;
import com.google.inject.AbstractModule;

public class CcForumModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CommentDao.class).toInstance(new CommentDaoImpl());
        bind(SessionDao.class).toInstance(new SessionDaoImpl());
        bind(ThreadDao.class).toInstance(new ThreadDaoImpl());
        bind(UserDao.class).toInstance(new UserDaoImpl());

        bind(ThreadSpi.class).to(ThreadSpiImpl.class);
        bind(ThreadsSpi.class).to(ThreadsSpiImpl.class);
        bind(UsersSpi.class).to(UsersSpiImpl.class);

    }
}
