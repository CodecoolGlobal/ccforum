package com.codecool.ccforum.ui.model;

public class CommentModel {

    private long id;
    private String authorName;
    private String content;

    public CommentModel(long id, String authorName, String content) {
        this.id = id;
        this.authorName = authorName;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
