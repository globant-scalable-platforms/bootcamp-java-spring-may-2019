package com.globant.bootcamp.spring.springcore.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.globant.bootcamp.spring.springcore.domain.Account;

public class DataSource {

	//private static List<Account> accounts;
	private static Map<String, String> accounts;

	public DataSource() {

		//accounts = new ArrayList<Account>();
		accounts = new HashMap<>();
		
		accounts.put("Ana", "pswana");
		accounts.put("Juan", "pswjuan");
		accounts.put("Pablo", "pswpablo");
		accounts.put("Maria", "pswmaria");
		accounts.put("Camilo", "pswcamilo");

	}

	public Account retrieveAccountInformation(String username) {

		if(accounts.containsKey(username)) {
			return new Account(username, accounts.get(username));
		}
		else {
			return null;
		}
		
	}

}
