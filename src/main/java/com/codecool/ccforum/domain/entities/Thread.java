package com.codecool.ccforum.domain.entities;

public class Thread implements Entity {

    private long id;
    private String title;
    private String description;
    private long authorId;

    public Thread() {
    }

    public Thread(String title, String description, long authorId) {
        this.title = title;
        this.description = description;
        this.authorId = authorId;
    }

    public Thread(long id, String title, String description, long authorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
