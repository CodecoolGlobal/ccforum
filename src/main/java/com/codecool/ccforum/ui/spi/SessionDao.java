package com.codecool.ccforum.ui.spi;

public interface SessionDao {

    public Session findById(long ssid);
    public Session createSession(long userId);

}
