package com.codecool.ccforum.persistence.datastore;

import com.codecool.ccforum.ui.spi.Session;
import com.codecool.ccforum.ui.spi.SessionDao;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public class SessionDsDao implements SessionDao {
    @Override
    public Session findById(long ssid) {
        return ObjectifyService.ofy().load().key(Key.create(Session.class, ssid)).now();
    }

    @Override
    public Session createSession(long userId) {
        Session ss = new Session(userId);
        ObjectifyService.ofy().save().entity(ss).now();
        return ss;
    }
}
