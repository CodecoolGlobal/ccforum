package com.codecool.ccforum.domain.dao;

import com.codecool.ccforum.domain.entities.Comment;

import java.util.List;

public interface CommentDao {

    public List<Comment> listComments(long threadId);
    public void saveComment(Comment comment);

}
