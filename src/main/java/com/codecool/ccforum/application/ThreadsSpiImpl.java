package com.codecool.ccforum.application;

import com.codecool.ccforum.domain.entities.Thread;
import com.codecool.ccforum.domain.services.ThreadService;
import com.codecool.ccforum.ui.model.ThreadListItemModel;
import com.codecool.ccforum.ui.spi.ThreadsSpi;
import com.google.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

public class ThreadsSpiImpl implements ThreadsSpi {

    private final ThreadService threadService;

    @Inject
    public ThreadsSpiImpl(ThreadService threadService) {
        this.threadService = threadService;
    }

    @Override
    public List<ThreadListItemModel> getAllThreads() {
        return threadService.listThreads().stream()
                .map((c) -> {
                    ThreadListItemModel res = new ThreadListItemModel(c.getId(), c.getTitle(), "Kiss Pista");
                    return res;
                }).collect(Collectors.toList());
    }

    @Override
    public long createNewThread(long id, String title, String desc) {
        Thread thread = threadService.createNewThread(1, title, desc);
        return thread.getId();
    }
}
