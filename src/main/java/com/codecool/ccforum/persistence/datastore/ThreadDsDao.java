package com.codecool.ccforum.persistence.datastore;

import com.codecool.ccforum.domain.dao.ThreadDao;
import com.codecool.ccforum.domain.entities.Thread;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;

public class ThreadDsDao implements ThreadDao {

    @Override
    public void createThread(Thread t) {
        ObjectifyService.ofy().save().entity(t).now();
    }

    @Override
    public Thread findById(long id) {
        return ObjectifyService.ofy().load().key(Key.create(Thread.class, id)).now();
    }

    @Override
    public List<Thread> findAll() {
        return ObjectifyService.ofy().load().type(Thread.class).list();
    }

    @Override
    public List<Thread> findUsersThreads(long userId) {
        return ObjectifyService.ofy()
                .load()
                .type(Thread.class)
                .filter("authorId", userId)
                .list();
    }
}
