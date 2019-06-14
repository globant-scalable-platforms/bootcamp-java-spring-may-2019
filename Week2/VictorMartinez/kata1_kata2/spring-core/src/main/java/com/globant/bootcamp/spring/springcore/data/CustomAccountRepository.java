package com.globant.bootcamp.spring.springcore.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.domain.Account;

@Repository
public class CustomAccountRepository implements AccountRepository {

    @Autowired
    private DataSource dataSource;

    public Account getAccount(String username) {

        return dataSource.retrieveUserInformation(username).equals(null)? null : new Account (username, dataSource.getPassWord(username));
        //return "Mike".equalsIgnoreCase(username)?new Account(username,"secret"):null;
    }



}