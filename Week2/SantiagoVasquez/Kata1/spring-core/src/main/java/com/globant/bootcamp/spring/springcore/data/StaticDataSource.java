package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;
import com.globant.bootcamp.spring.springcore.utilities.RandomStrings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class StaticDataSource implements DataSourceInterface {

    private List<Account> accounts = new ArrayList<>(Arrays.asList(
            new Account("Mike", "123456"),
            new Account("Andres", "asdfgh"),
            new Account("Camilo", "qwerty")
    ));

    @Override
    public Account retrieveUserInformation(String username) {
        final Optional<Account> optionalAccount = accounts.stream().filter(acc -> acc.getUsername().equals(username)).findFirst();
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else {
            final Account newAccount = new Account(username, RandomStrings.randomAlphaNumeric(6));
            accounts.add(newAccount);
            return newAccount;
        }
    }
}
