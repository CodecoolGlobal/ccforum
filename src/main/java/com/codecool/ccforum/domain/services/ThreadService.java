package com.codecool.ccforum.domain.services;

import com.codecool.ccforum.domain.dao.ThreadDao;
import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.entities.Thread;
import com.codecool.ccforum.domain.entities.User;
import com.google.inject.Inject;

import java.util.List;

public class ThreadService {

    private UserDao userDao;
    private ThreadDao threadDao;

    @Inject
    public ThreadService(UserDao userDao, ThreadDao threadDao) {
        this.userDao = userDao;
        this.threadDao = threadDao;
    }

    public Thread createNewThread(long authorId, String title, String desc) {
        checkUserExists(authorId);
        if (title == null || title.trim().length() < 1) {
            throw new IllegalArgumentException("The title is mandatory!");
        }
        if (desc == null || desc.trim().length() < 1) {
            throw new IllegalArgumentException("The desc is mandatory!");
        }

        Thread thread = new Thread(title, desc, authorId);
        threadDao.createThread(thread);
        return thread;
    }

    public List<Thread> listThreads() {
        return threadDao.findAll();
    }

    public List<Thread> listUsersThreads(long userId) {
        checkUserExists(userId);
        return threadDao.findUsersThreads(userId);
    }

    public Thread findById(long id) {
        return threadDao.findById(id);
    }



    private void checkUserExists(long userId) {
        User author = userDao.findById(userId);
        if (author == null) {
            throw new IllegalArgumentException("Invalid user id: " + userId);
        }
    }

}
