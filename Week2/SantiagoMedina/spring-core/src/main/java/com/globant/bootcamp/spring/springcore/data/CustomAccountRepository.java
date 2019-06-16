package com.globant.bootcamp.spring.springcore.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.domain.Account;

@Repository
public class CustomAccountRepository implements AccountRepository {
	
	@Autowired
	private DataSource datasource;

    public Account getAccount(String username) {
    	return datasource.retrieveAccountInformation(username);
    }
}