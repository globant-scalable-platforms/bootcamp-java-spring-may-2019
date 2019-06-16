package com.globant.bootcamp.spring.springcore.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.globant.bootcamp.spring.springcore.domain.Account;

@Service
public class DataSourceImpl implements DataSource{

	private List<Account> accounts;
	
	public DataSourceImpl() {
		accounts = new ArrayList<>();
		accounts.add(new Account("Santiago","secret1"));
		accounts.add(new Account("Felipe","secret2"));
		accounts.add(new Account("Fernando","secret3"));
		accounts.add(new Account("Francia","secret4"));
		accounts.add(new Account("Camila","secret5"));
		accounts.add(new Account("Laura","secret6"));
		accounts.add(new Account("Marco","secret7"));
		accounts.add(new Account("Fernanda","secret8"));
		accounts.add(new Account("Leyda","secret9"));
		accounts.add(new Account("Daniel","secret10"));
		accounts.add(new Account("Valentina","secret11"));
	}

	@Override
	public Account retrieveAccountInformation(String username) {
		Account account = accounts.stream()
				.filter(ac -> ac.getUsername().equals(username))
				.findFirst()
				.orElse(null);
		
		return account == null ? null : account;
	}
	
}
