package com.codecool.ccforum.ui.controller;

import com.codecool.ccforum.ui.model.NewThreadModel;
import com.codecool.ccforum.ui.spi.Session;
import com.codecool.ccforum.ui.spi.SessionDao;
import com.codecool.ccforum.ui.spi.ThreadsSpi;
import com.google.inject.Inject;

public class NewThreadController {

    private final ThreadsSpi threadsSpi;
    private final SessionDao sessionDao;

    @Inject
    public NewThreadController(ThreadsSpi threadsSpi, SessionDao sessionDao) {
        this.threadsSpi = threadsSpi;
        this.sessionDao = sessionDao;
    }

    public NewThreadModel onSubmit(String title, String description, String ssidStr) {
        String titleError = null;
        String descError = null;
        if (title == null || title.trim().length() < 3) {
            titleError = "The title must be minimum 3 characters!";
        }
        title = title.trim();
        if (description == null || description.trim().length() < 3) {
            descError = "The description must be minimum 3 characters!";
        }
        description = description.trim();

        if (titleError != null || descError != null) {
            return new NewThreadModel(titleError, descError);
        }

        long ssid = Long.parseLong(ssidStr);
        Session ss = sessionDao.findById(ssid);
        if (ss == null) {
            throw new IllegalArgumentException("Invalid ssid");
        }

        long newThreadId = threadsSpi.createNewThread(ss.getUserId(), title, description);
        return new NewThreadModel(newThreadId);
    }


}
