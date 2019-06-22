package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.domain.Account;

import java.util.Objects;

@Repository
public class CustomAccountRepository implements AccountRepository {

    @Autowired
    DataSource dataSource;

    public Account getAccount(String username) {

        User user = dataSource.retrieveUserInformation(username);

        if(Objects.nonNull(user)){
            return new Account(username,user.getPassword());
        }

        return null;
    }
}