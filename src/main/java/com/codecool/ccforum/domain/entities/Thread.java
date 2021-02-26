package com.codecool.ccforum.domain.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Thread {

    @Id
    private Long id;

    private String title;
    private String description;

    @Index
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
