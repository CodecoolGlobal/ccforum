package com.codecool.ccforum.persistence.datastore;

import com.codecool.ccforum.domain.dao.CommentDao;
import com.codecool.ccforum.domain.entities.Comment;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;

public class CommentDsDao implements CommentDao {
    @Override
    public List<Comment> listComments(long threadId) {
        return ObjectifyService.ofy().load().type(Comment.class).filter("threadId", threadId).list();
    }

    @Override
    public void saveComment(Comment comment) {
        ObjectifyService.ofy().save().entity(comment).now();
    }
}
