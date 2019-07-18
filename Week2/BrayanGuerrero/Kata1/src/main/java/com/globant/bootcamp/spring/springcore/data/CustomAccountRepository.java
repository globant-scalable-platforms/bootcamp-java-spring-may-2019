package com.globant.bootcamp.spring.springcore.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.business.DataSource;
import com.globant.bootcamp.spring.springcore.domain.Account;

@Repository
public class CustomAccountRepository implements AccountRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public Account getAccount(String username) {
        return dataSource.getAccount(username);
    }

    public Account getInformation(String username) {
        return dataSource.retrieveUserInformation(username);
    }
}