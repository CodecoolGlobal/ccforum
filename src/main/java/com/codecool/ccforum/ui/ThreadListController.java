package com.codecool.ccforum.ui;

import com.codecool.ccforum.domain.services.ThreadService;

public class ThreadListController {

    public void onCreateNewTrheadClicked() {
        new ThreadService().createNewThread()
    }

}
