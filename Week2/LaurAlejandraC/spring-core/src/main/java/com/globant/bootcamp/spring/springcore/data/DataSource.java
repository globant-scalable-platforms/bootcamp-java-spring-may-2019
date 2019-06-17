package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static List<Account> accounts;

    public DataSource(){
        accounts = new ArrayList<>();
        accounts.add(new Account("user", "pass"));
        accounts.add(new Account("Laura", "superSecret"));
        accounts.add(new Account("Name", "Pass1234"));
        accounts.add(new Account("SomeName", "5678"));
    }

    public Account retrieveAccountInformation(String username){
        Account result = accounts.stream()
                .filter(a -> a.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        return result == null ? null : new Account(result.getUsername(), result.getPassword());
    }
}
