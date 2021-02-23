package com.codecool.ccforum.ui.spi;

import com.codecool.ccforum.domain.entities.Entity;

public class Session implements Entity {

    private long id;
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

    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }
}
