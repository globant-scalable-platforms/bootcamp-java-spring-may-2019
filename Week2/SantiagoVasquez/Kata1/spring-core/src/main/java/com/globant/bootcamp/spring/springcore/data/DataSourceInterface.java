package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;

public interface DataSourceInterface {

    Account retrieveUserInformation(String username);
}
