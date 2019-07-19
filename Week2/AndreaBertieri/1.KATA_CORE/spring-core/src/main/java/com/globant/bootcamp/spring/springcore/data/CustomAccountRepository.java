package com.globant.bootcamp.spring.springcore.data;

import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.domain.Account;

@Repository
public class CustomAccountRepository implements AccountRepository {
	
	private DataSource dataSource;

	public CustomAccountRepository(final DataSource dataSource) {
		this.dataSource= dataSource;
	}
	
	@Override
	public Account getAccount(String username) {
		return "Mike".equalsIgnoreCase(username)?new Account(username,"secret"):null;
	}	
	
	public String retrieveAccountInformation(String username, String password) {
		return dataSource.getDataSource().containsKey(username)?
				(password.equalsIgnoreCase(dataSource.getOneDataSource(username))?
				"Wellcome":"Wrong Password"): dataSource.setAccount(username, password); 
	}
    
}