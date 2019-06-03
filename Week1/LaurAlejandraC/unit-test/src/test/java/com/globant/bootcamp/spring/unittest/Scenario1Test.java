package com.globant.bootcamp.spring.unittest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import springbootcamp.unittest.kata.business.AccountServiceImpl;
import springbootcamp.unittest.kata.data.AccountRepository;
import springbootcamp.unittest.kata.data.AccountRepositoryImpl;
import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;
import springbootcamp.unittest.kata.domain.TransferResponse;

import java.util.ArrayList;
import java.util.Arrays;

public class Scenario1Test {
    private AccountRepository accountRepository;
    private Account currentAccount;
    private Account savingsAccount;

    @Before
    public void setUp(){
        currentAccount = new Account("User", 3000, AccountType.CURRENT);
        savingsAccount = new Account("User", 1500, AccountType.SAVING);
        accountRepository = new AccountRepositoryImpl(new ArrayList<>(Arrays.asList(currentAccount, savingsAccount)));
    }

    @Test
    public void transfer(){
        AccountServiceImpl accountService = new AccountServiceImpl(accountRepository);

        try{
            TransferResponse transferResponse = accountService.transferMoney(currentAccount, savingsAccount, 2500);
            Assert.assertTrue(transferResponse.getCurrentAccount().getBalance() == 500 && transferResponse.getSavingAccount().getBalance() == 4000);
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
