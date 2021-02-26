package com.codecool.ccforum.application;

import com.codecool.ccforum.domain.dao.CommentDao;
import com.codecool.ccforum.domain.dao.ThreadDao;
import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.persistence.datastore.CommentDsDao;
import com.codecool.ccforum.persistence.datastore.SessionDsDao;
import com.codecool.ccforum.persistence.datastore.ThreadDsDao;
import com.codecool.ccforum.persistence.datastore.UserDsDao;
import com.codecool.ccforum.ui.spi.SessionDao;
import com.codecool.ccforum.ui.spi.ThreadSpi;
import com.codecool.ccforum.ui.spi.ThreadsSpi;
import com.codecool.ccforum.ui.spi.UsersSpi;
import com.google.inject.AbstractModule;

public class CcForumModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CommentDao.class).toInstance(new CommentDsDao());
        bind(SessionDao.class).toInstance(new SessionDsDao());
        bind(ThreadDao.class).toInstance(new ThreadDsDao());
        bind(UserDao.class).toInstance(new UserDsDao());

        bind(ThreadSpi.class).to(ThreadSpiImpl.class);
        bind(ThreadsSpi.class).to(ThreadsSpiImpl.class);
        bind(UsersSpi.class).to(UsersSpiImpl.class);

    }
}
