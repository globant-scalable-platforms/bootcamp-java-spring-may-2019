package com.globant.bootcamp.spring.springcore.domain;

public class Account {

    private String username;
    private String password;

    public Account(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
