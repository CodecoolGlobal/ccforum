package com.codecool.ccforum.persistence;

import com.codecool.ccforum.persistence.BaseDao;
import com.codecool.ccforum.domain.dao.ThreadDao;
import com.codecool.ccforum.domain.entities.Thread;

import java.util.List;

public class ThreadDaoImpl extends BaseDao<Thread> implements ThreadDao {
    @Override
    public void createThread(Thread t) {
        this.save(t);
    }

    @Override
    public List<Thread> findAll() {
        return this.find((e) -> true);
    }

    @Override
    public List<Thread> findUsersThreads(long userId) {
        return this.find((e) -> e.getAuthorId() == userId);
    }
}
