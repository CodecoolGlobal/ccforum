package com.codecool.ccforum.domain.dao;

import com.codecool.ccforum.domain.entities.Thread;

import java.util.List;

public interface ThreadDao {

    public void createThread(Thread t);

    public Thread findById(long id);

    public List<Thread> findAll();

    public List<Thread> findUsersThreads(long userId);

}
