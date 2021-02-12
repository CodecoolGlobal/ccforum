package com.codecool.ccforum.ui.spi;

import com.codecool.ccforum.ui.model.CommentModel;
import com.codecool.ccforum.ui.model.ThreadModel;

import java.util.ArrayList;

public class MockThreadSpi implements ThreadSpi {
    @Override
    public ThreadModel findThread(long id) {
        ThreadModel res = new ThreadModel(id, "Mock Thread subject", "this is just a mock thread", new ArrayList<>());
        res.getComments().add(new CommentModel(1, "Kiss Pista", "comment 1 content"));
        res.getComments().add(new CommentModel(2, "Kiss Pista", "comment 2 content"));
        res.getComments().add(new CommentModel(3, "Kiss Pista", "comment 3 content"));
        return res;
    }
}
