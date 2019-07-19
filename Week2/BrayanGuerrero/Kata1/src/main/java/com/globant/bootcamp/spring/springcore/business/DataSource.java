/**
 * 
 */
package com.globant.bootcamp.spring.springcore.business;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.globant.bootcamp.spring.springcore.domain.Account;

/**
 * @author brayanguerrero
 *
 */
@Service
public class DataSource {
	
	static final Map<String, Account> accounts = new HashMap<>();
	
	public DataSource() {
		accounts.put("Mike", new Account("Mike", "123"));
		accounts.put("Mauro", new Account("Mauro", "456"));
		accounts.put("Daniel", new Account("Daniel", "789"));
	}
	
	public Account retrieveUserInformation (String username) {
		Account account = accounts.get(username);
		
		if(account == null) {
			account = new Account(username, "temporal");
			accounts.put(username, account);
			return account;
		}
		
		return account;
	}

	public Account getAccount(String username) {
		return accounts.get(username);
	}
}
