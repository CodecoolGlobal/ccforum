package com.codecool.ccforum.persistence;

import com.codecool.ccforum.ui.spi.Session;
import com.codecool.ccforum.ui.spi.SessionDao;

public class SessionDaoImpl extends BaseDao<Session> implements SessionDao {

    @Override
    public Session createSession(long userId) {
        Session session = new Session(userId);
        this.save(session);
        return session;
    }
}
