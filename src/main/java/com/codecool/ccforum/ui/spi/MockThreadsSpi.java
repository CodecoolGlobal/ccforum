package com.codecool.ccforum.ui.spi;

import com.codecool.ccforum.domain.entities.Thread;
import com.codecool.ccforum.ui.model.ThreadListItemModel;

import java.util.ArrayList;
import java.util.List;

public class MockThreadsSpi implements ThreadsSpi {

    private static int nextId = 1;

    @Override
    public List<ThreadListItemModel> getAllThreads() {
        List<ThreadListItemModel> res = new ArrayList<>();
        res.add(new ThreadListItemModel(nextId++, "Thread 1 Mock", "Kiss Istvan"));
        res.add(new ThreadListItemModel(nextId++, "Thread 2 Mock", "Nagy Istvan"));
        res.add(new ThreadListItemModel(nextId++, "Thread 3 Mock", "Kozepes Istvan"));
        return res;
    }

    @Override
    public long createNewThread(long id, String title, String desc) {
        return nextId++;
    }

}
