package com.globant.bootcamp.spring.springcore.business;

public interface Authenticator {
    
    public boolean authenticate(final String username, final String password);
}
