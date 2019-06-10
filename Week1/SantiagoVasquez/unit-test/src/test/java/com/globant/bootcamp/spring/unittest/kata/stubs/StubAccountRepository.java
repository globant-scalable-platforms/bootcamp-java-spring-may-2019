package com.globant.bootcamp.spring.unittest.kata.stubs;


import springbootcamp.unittest.kata.data.AccountRepository;
import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;

public class StubAccountRepository implements AccountRepository {

    @Override
    public Account findAccountByUsernameAndType(String username, AccountType accountType) {
        if (username.equals("Mike") && accountType == AccountType.SAVING) {
            return new Account(username, 1500, accountType);
        } else if (username.equals("Santi") && accountType == AccountType.CURRENT) {
            return new Account(username, 3000, accountType);
        } else if (username.equals("Andres") && accountType == AccountType.SAVING) {
            return new Account(username, 200, accountType);
        } else if (username.equals("Camilo") && accountType == AccountType.CURRENT) {
            return new Account(username, 100, accountType);
        }
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }
}
