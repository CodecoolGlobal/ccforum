package com.codecool.ccforum.domain.entities;

public class User implements Entity {

    private long id;
    private String email;
    private String name;
    private String pasword;

    public User() {
    }

    public User(String email, String name, String pasword) {
        this.email = email;
        this.name = name;
        this.pasword = pasword;
    }

    public User(long id, String email, String name, String pasword) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.pasword = pasword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
