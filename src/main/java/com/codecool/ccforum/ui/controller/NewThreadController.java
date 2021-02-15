package com.codecool.ccforum.ui.controller;

import com.codecool.ccforum.ui.model.NewThreadModel;
import com.codecool.ccforum.ui.spi.ThreadsSpi;

public class NewThreadController {

    private final ThreadsSpi threadsSpi;

    public NewThreadController(ThreadsSpi threadsSpi) {
        this.threadsSpi = threadsSpi;
    }

    public NewThreadModel onSubmit(String title, String description) {
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

        long newThreadId = threadsSpi.createNewThread(1, title, description);
        return new NewThreadModel(newThreadId);
    }


}
