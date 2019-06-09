package com.globant.bootcamp.spring.springcore.domain;

import com.globant.bootcamp.spring.springcore.domain.Account;

import java.util.Arrays;
import java.util.List;

public class DataSource {

    private static List<Account> accounts;

    public DataSource() {
        accounts = Arrays.asList(
                new Account("Mike", "secret"),
                new Account("Nicolas", "Sastoque"),
                new Account("User", "password")
        );
    }

    public Account retrieveUserInformation(String username){

        return accounts.stream()
                .filter(object -> object.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
