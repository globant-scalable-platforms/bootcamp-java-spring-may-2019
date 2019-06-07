package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;
import com.globant.bootcamp.spring.springcore.utilities.RandomStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class StaticDataSource implements DataSourceInterface {

    private Map<String, Account> accounts = new HashMap<>();

    @Autowired
    public StaticDataSource() {
        accounts = new HashMap<>();
        accounts.put("Mike", new Account("Mike", "123456"));
        accounts.put("Andres", new Account("Andres", "asdfgh"));
        accounts.put("Camilo", new Account("Camilo", "qwerty"));
    }

    @Override
    public Account retrieveUserInformation(String username) {
        final Account account = accounts.get(username);
        if (Objects.nonNull(account)) {
            return account;
        } else {
            final Account newAccount = new Account(username, RandomStrings.randomAlphaNumeric(6));
            accounts.put(username, newAccount);
            return newAccount;
        }
    }
}
