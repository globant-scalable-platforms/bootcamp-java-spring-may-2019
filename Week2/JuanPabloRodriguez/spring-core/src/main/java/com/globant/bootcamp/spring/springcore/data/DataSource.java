package com.globant.bootcamp.spring.springcore.data;

import java.util.ArrayList;
import java.util.List;

import com.globant.bootcamp.spring.springcore.domain.Account;

public class DataSource {

	private static List<Account> accounts;

	public DataSource() {

		accounts = new ArrayList<Account>();

		accounts.add(new Account("Ana", "pswana"));
		accounts.add(new Account("Juan", "pswjuan"));
		accounts.add(new Account("Pablo", "pswpablo"));
		accounts.add(new Account("Maria", "pswmaria"));
		accounts.add(new Account("Camilo", "pswcamilo"));
		accounts.add(new Account("Mike", "pswmike"));
		accounts.add(new Account("Jhon", "pswjhon"));
		accounts.add(new Account("Andy", "pswandy"));
		accounts.add(new Account("Carl", "pswcarl"));
		accounts.add(new Account("Lina", "pswlina"));

	}

	public Account retrieveAccountInformation(String username) {

		Account result = accounts.stream()
				.filter(x -> username.equals(x.getUsername()))
				.findAny()
				.orElse(null);

		return result;

	}

}
