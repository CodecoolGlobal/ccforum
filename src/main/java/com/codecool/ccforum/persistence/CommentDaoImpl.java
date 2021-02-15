package com.codecool.ccforum.persistence;

import com.codecool.ccforum.domain.dao.CommentDao;
import com.codecool.ccforum.domain.entities.Comment;

import java.util.List;

public class CommentDaoImpl extends BaseDao<Comment> implements CommentDao {
    @Override
    public List<Comment> listComments(long threadId) {
        // db  connections
        // prepared statement
        // execute query
        // iterate over resul set
        // convert result set item to commant
        // put to list
        // return list
        return this.find((c) -> c.getThreadId() == threadId);
    }

    @Override
    public void saveComment(Comment comment) {
        this.save(comment);
    }
}
