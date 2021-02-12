package com.codecool.ccforum.ui.model;

import java.util.List;

public class ThreadModel {

    private long id;
    private String subject;
    private String description;
    private List<CommentModel> comments;

    public ThreadModel(long id, String subject, String description, List<CommentModel> comments) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.comments = comments;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}
