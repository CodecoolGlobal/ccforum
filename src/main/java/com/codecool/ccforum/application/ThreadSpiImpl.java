package com.codecool.ccforum.application;

import com.codecool.ccforum.domain.entities.Comment;
import com.codecool.ccforum.domain.entities.Thread;
import com.codecool.ccforum.domain.services.CommentService;
import com.codecool.ccforum.domain.services.ThreadService;
import com.codecool.ccforum.ui.model.CommentModel;
import com.codecool.ccforum.ui.model.ThreadModel;
import com.codecool.ccforum.ui.spi.ThreadSpi;

import java.util.List;
import java.util.stream.Collectors;

public class ThreadSpiImpl implements ThreadSpi {

    private final ThreadService threadService;
    private final CommentService commentService;

    public ThreadSpiImpl(ThreadService threadService, CommentService commentService) {
        this.threadService = threadService;
        this.commentService = commentService;
    }

    @Override
    public ThreadModel findThread(long id) {
        Thread thread = threadService.findById(id);
        List<Comment> comments = commentService.listCommentsOfThread(id);
        ThreadModel model = new ThreadModel(thread.getId(), thread.getTitle(), thread.getDescription(),
                comments.stream()
                        .map((c) -> {
                            CommentModel res = new CommentModel(c.getId(), "Kiss Pista", c.getContent());
                            return res;
                        }).collect(Collectors.toList())
        );
        return model;
    }
}
