package com.codecool.ccforum.ui.model;

public class ThreadListItemModel {

    private long id;
    private String subject;
    private String authorName;

    public ThreadListItemModel(long id, String subject, String authorName) {
        this.id = id;
        this.subject = subject;
        this.authorName = authorName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
