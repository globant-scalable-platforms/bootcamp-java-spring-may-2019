package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.domain.Account;


@Repository
public class CustomAccountRepository implements AccountRepository {

    @Autowired
    @Qualifier(value = "dataSource")
    DataSource dataSource;

    public Account getAccount(String username) {
        return dataSource.retrieveUserInformation(username);
    }
}