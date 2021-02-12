package com.codecool.ccforum.ui.controller;

import com.codecool.ccforum.ui.model.ThreadModel;
import com.codecool.ccforum.ui.spi.ThreadSpi;

public class ThreadController {

    private final ThreadSpi threadSpi;

    public ThreadController(ThreadSpi threadSpi) {
        this.threadSpi = threadSpi;
    }

    public ThreadModel onLoad(String idStr) {
        Long id = Long.parseLong(idStr);
        return threadSpi.findThread(id);
    }

}
