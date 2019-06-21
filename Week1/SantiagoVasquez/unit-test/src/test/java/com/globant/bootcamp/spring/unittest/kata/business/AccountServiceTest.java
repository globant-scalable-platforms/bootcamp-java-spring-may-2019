package com.globant.bootcamp.spring.unittest.kata.business;

import com.globant.bootcamp.spring.unittest.kata.stubs.StubAccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import springbootcamp.unittest.kata.business.AccountService;
import springbootcamp.unittest.kata.business.AccountServiceImpl;
import springbootcamp.unittest.kata.data.AccountRepository;
import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;
import springbootcamp.unittest.kata.domain.TransferResponse;

import javax.security.auth.login.AccountException;

public class AccountServiceTest {

    private AccountRepository accountRepository;
    private AccountService accountService;

    private Account currentAccount;
    private Account savingsAccount;

    @Before
    public void setUp() {
        accountRepository = new StubAccountRepository();
        accountService = AccountServiceImpl.getInstance(accountRepository);
    }

    @Test
    public void transferringMoneyBetweenAccounts() {
        final TransferResponse transferResponse;

        currentAccount = accountService.retrieveAccount("Santi", AccountType.CURRENT);
        savingsAccount = accountService.retrieveAccount("Mike", AccountType.SAVING);

        try {
            transferResponse = accountService.transferMoney(currentAccount, savingsAccount, 2500);
        } catch (AccountException e) {
            Assert.fail();
        }

        Assert.assertEquals(currentAccount.getBalance(), 500);
        Assert.assertEquals(savingsAccount.getBalance(), 4000);
    }

    @Test(expected = AccountException.class)
    public void transferringInsufficientFunds() throws AccountException {
        final TransferResponse transferResponse;

        currentAccount = accountService.retrieveAccount("Camilo", AccountType.CURRENT);
        savingsAccount = accountService.retrieveAccount("Andres", AccountType.SAVING);

        transferResponse = accountService.transferMoney(currentAccount, savingsAccount, 400);
    }
}
