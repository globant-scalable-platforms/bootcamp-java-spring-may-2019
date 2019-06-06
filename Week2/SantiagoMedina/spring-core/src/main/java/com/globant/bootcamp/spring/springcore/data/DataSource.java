package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;

public interface DataSource {

	Account retrieveAccountInformation(String username);
	
}
