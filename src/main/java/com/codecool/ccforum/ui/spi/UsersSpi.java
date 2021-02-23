package com.codecool.ccforum.ui.spi;

public interface UsersSpi {

    public long registerUser(String name, String email, String password);
    public Long findUserByEmailPassword(String email, String password);

}
