package com.codecool.ccforum.ui.model;

public class NewThreadModel {

    private String titleError;
    private String descriptionError;
    private boolean success;
    private long newThreadId;

    public NewThreadModel(long newThreadId) {
        this.newThreadId = newThreadId;
        this.success = true;
    }

    public NewThreadModel(String titleError, String descriptionError) {
        this.titleError = titleError;
        this.descriptionError = descriptionError;
        this.success = false;
    }

    public String getTitleError() {
        return titleError;
    }

    public void setTitleError(String titleError) {
        this.titleError = titleError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getNewThreadId() {
        return newThreadId;
    }

    public void setNewThreadId(long newThreadId) {
        this.newThreadId = newThreadId;
    }
}
