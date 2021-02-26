package com.codecool.ccforum.ui.spi;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Session {

    @Id
    private Long id;
    private long userId;

    public Session(long id, long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Session(long userId) {
        this.userId = userId;
    }

    public Session() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }
}
