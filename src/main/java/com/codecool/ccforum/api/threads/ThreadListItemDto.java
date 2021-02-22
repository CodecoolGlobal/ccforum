package com.codecool.ccforum.api.threads;

public class ThreadListItemDto {

    private long id;
    private String title;
    private String desc;
    private long authorId;

    public ThreadListItemDto(long id, String title, String desc, long authorId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.desc = desc;
    }

    public ThreadListItemDto() {
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

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
