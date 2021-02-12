package com.codecool.ccforum.ui.model;

import java.util.ArrayList;
import java.util.List;

public class ThreadListModel {

    private final List<ThreadListItemModel> threads = new ArrayList<>();

    public List<ThreadListItemModel> getThreads() {
        return threads;
    }
}
