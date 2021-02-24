package com.codecool.ccforum.domain.services;

import com.codecool.ccforum.domain.dao.CommentDao;
import com.codecool.ccforum.domain.dao.ThreadDao;
import com.codecool.ccforum.domain.dao.UserDao;
import com.codecool.ccforum.domain.entities.Comment;
import com.codecool.ccforum.persistence.UserDaoImpl;
import com.google.inject.Inject;

import java.util.List;

public class CommentService {

    private final UserDao userDao;
    private final ThreadDao threadDao;
    private final CommentDao commentDao;

    @Inject
    public CommentService(UserDao userDao, ThreadDao threadDao, CommentDao commentDao) {
        this.userDao = userDao;
        this.threadDao = threadDao;
        this.commentDao = commentDao;
    }

    public List<Comment> listCommentsOfThread(long threadId) {
        return commentDao.listComments(threadId);
    }

    public Comment createComment(long authorId, long threadId, String description) {
        if (userDao.findById(authorId) == null) {
            throw new IllegalArgumentException();
        }
        if (threadDao.findById(threadId) == null) {
            throw new IllegalArgumentException();
        }
        if (description == null || description.trim().length() < 1) {
            throw new IllegalArgumentException();
        }

        Comment comment = new Comment(authorId, threadId, System.currentTimeMillis(), description);
        commentDao.saveComment(comment);
        return comment;
    }

}
