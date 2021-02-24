package com.codecool.ccforum.ui.controller;

import com.codecool.ccforum.ui.model.ThreadListModel;
import com.codecool.ccforum.ui.spi.ThreadsSpi;
import com.google.inject.Inject;

public class ThreadListController {

    private final ThreadsSpi threadsSpi;

    @Inject
    public ThreadListController(ThreadsSpi threadsSpi) {
        this.threadsSpi = threadsSpi;
    }

    public ThreadListModel onLoad() {
        ThreadListModel res = new ThreadListModel();
        res.getThreads().addAll(threadsSpi.getAllThreads());
        return res;
    }



}
