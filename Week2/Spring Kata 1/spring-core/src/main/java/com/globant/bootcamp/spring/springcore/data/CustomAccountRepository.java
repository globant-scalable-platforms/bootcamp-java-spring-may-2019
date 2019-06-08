package com.globant.bootcamp.spring.springcore.data;

import org.springframework.stereotype.Repository;
import com.globant.bootcamp.spring.springcore.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class CustomAccountRepository implements AccountRepository {

    private DataSource dataSource;

    @Autowired
    public CustomAccountRepository(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Account getAccount(String username) {
        return dataSource.retrieveUserInformation(username);
    }
}