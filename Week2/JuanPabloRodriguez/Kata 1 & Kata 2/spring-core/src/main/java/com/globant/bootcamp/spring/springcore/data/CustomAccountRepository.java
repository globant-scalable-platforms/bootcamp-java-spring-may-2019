package com.globant.bootcamp.spring.springcore.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.domain.Account;

@Repository
public class CustomAccountRepository implements AccountRepository {

	DataSource dataSource;

	@Autowired
	public CustomAccountRepository(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Account getAccount(String username) {
		return dataSource.retrieveAccountInformation(username);
	}
}