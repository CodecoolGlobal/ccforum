package com.codecool.ccforum.ui.spi;

import com.codecool.ccforum.ui.model.ThreadListItemModel;

import java.util.List;

public interface ThreadsSpi {

    public List<ThreadListItemModel> getAllThreads();
    public long createNewThread(long authorId, String title, String desc);

}
