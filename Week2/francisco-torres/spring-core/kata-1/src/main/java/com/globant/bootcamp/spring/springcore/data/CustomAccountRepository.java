package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.DataSource;
import com.globant.bootcamp.spring.springcore.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CustomAccountRepository implements AccountRepository {

    @Autowired
    @Qualifier(value="dataSourceSingleton")
    DataSource dataSource;

    public Account getAccount(String username) {
        return dataSource.retrieveAccountInformation(username);
    }
}