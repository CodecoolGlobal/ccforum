package com.codecool.ccforum.domain.entities;

public class Comment implements Entity {

    private long id;
    private long authorId;
    private long threadId;
    private long createdAt;
    private String content;

    public Comment() {
    }

    public Comment(long authorId, long threadId, long createdAt, String content) {
        this.authorId = authorId;
        this.threadId = threadId;
        this.createdAt = createdAt;
        this.content = content;
    }

    public Comment(long id, long authorId, long threadId, long createdAt, String content) {
        this.id = id;
        this.authorId = authorId;
        this.threadId = threadId;
        this.createdAt = createdAt;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }
}
