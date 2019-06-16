package com.globant.bootcamp.spring.unittest;

import org.junit.Before;
import org.junit.Test;
import springbootcamp.unittest.kata.business.AccountService;
import springbootcamp.unittest.kata.business.AccountServiceImpl;
import springbootcamp.unittest.kata.data.AccountRepository;
import springbootcamp.unittest.kata.data.AccountRepositoryImpl;
import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;
import springbootcamp.unittest.kata.exception.AccountException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class Scenario2Test {
    private AccountRepository accountRepository;
    private Account currentAccount;
    private Account savingsAccount;

    @Before
    public void setUp(){
        currentAccount = new Account("User", 100, AccountType.CURRENT);
        savingsAccount = new Account("User", 200, AccountType.SAVING);
        accountRepository = new AccountRepositoryImpl(new ArrayList<>(Arrays.asList(currentAccount, savingsAccount)));
    }

    @Test
    public void transferException(){
        AccountService accountService = new AccountServiceImpl(accountRepository);

        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountService.transferMoney(currentAccount, savingsAccount, 400))
                .withMessage("insufficient funds");
    }
}
