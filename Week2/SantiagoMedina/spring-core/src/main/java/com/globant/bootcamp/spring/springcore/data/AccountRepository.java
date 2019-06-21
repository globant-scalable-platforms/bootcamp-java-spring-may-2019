package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;

public interface AccountRepository {

    Account getAccount(String username);
}
