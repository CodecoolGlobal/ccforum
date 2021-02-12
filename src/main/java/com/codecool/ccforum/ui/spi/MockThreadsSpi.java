package com.codecool.ccforum.ui.spi;

import com.codecool.ccforum.ui.model.ThreadListItemModel;

import java.util.ArrayList;
import java.util.List;

public class MockThreadsSpi implements ThreadsSpi {

    @Override
    public List<ThreadListItemModel> getAllThreads() {
        List<ThreadListItemModel> res = new ArrayList<>();
        res.add(new ThreadListItemModel(1, "Thread 1 Mock", "Kiss Istvan"));
        res.add(new ThreadListItemModel(2, "Thread 2 Mock", "Nagy Istvan"));
        res.add(new ThreadListItemModel(3, "Thread 3 Mock", "Kozepes Istvan"));
        return res;
    }

}
