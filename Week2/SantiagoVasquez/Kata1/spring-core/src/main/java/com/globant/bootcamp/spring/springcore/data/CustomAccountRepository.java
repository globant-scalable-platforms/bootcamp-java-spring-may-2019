package com.globant.bootcamp.spring.springcore.data;

import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.domain.Account;

@Repository
public class CustomAccountRepository implements AccountRepository {

    public Account getAccount(String username) {
        return "Mike".equalsIgnoreCase(username)?new Account(username,"secret"):null;
    }
}