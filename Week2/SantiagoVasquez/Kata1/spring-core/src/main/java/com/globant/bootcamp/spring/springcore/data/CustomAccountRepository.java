package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomAccountRepository implements AccountRepository {

    @Autowired
    private DataSourceInterface dataSource;

    public Account getAccount(String username) {
        return dataSource.retrieveUserInformation(username);
//        return "Mike".equalsIgnoreCase(username)?new Account(username,"secret"):null;
    }
}