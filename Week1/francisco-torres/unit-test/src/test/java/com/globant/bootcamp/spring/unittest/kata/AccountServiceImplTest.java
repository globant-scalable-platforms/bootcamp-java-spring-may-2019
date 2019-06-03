package com.globant.bootcamp.spring.unittest.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import springbootcamp.unittest.kata.business.AccountServiceImpl;
import springbootcamp.unittest.kata.data.AccountRepository;
import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;
import java.lang.reflect.Constructor;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    private Account currentAccount;
    private Account savingAccount;
    private int initialBalanceCurrentAccount;
    private int initialBalanceSavingAccount;
    private int transferAmount;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        try {
            Constructor<Account> c = Account.class.getDeclaredConstructor(String.class, int.class, AccountType.class);
            c.setAccessible(true);
            currentAccount = c.newInstance("Ana", 0, AccountType.CURRENT);
            savingAccount = c.newInstance("Pedro", 0, AccountType.SAVING);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        when(accountRepository.findAccountByUsernameAndType("Ana", AccountType.CURRENT)).thenReturn(currentAccount);
        when(accountRepository.findAccountByUsernameAndType("Pedro", AccountType.SAVING)).thenReturn(savingAccount);
        when(accountRepository.updateAccount(currentAccount)).thenReturn(currentAccount);
        when(accountRepository.updateAccount(savingAccount)).thenReturn(savingAccount);
    }

    @Test
    public void transferMoneyBeetwenAccounts() {
        transferAmount = 2500;
        initialBalanceCurrentAccount = 3000;
        initialBalanceSavingAccount = 1500;

        currentAccount.setBalance(initialBalanceCurrentAccount);
        savingAccount.setBalance(initialBalanceSavingAccount);

        try {
            accountService.transferMoney(currentAccount,savingAccount,transferAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assert.assertTrue(currentAccount.getBalance() == (initialBalanceCurrentAccount - transferAmount));
        Assert.assertTrue(savingAccount.getBalance() == (initialBalanceSavingAccount + transferAmount));
    }

    @Test
    public void transferInsufficientFunds() {
        transferAmount = 400;
        initialBalanceCurrentAccount = 100;
        initialBalanceSavingAccount = 200;

        currentAccount.setBalance(initialBalanceCurrentAccount);
        savingAccount.setBalance(initialBalanceSavingAccount);

        try {
            accountService.transferMoney(currentAccount,savingAccount,transferAmount);
        } catch (Exception e) {
            Assert.assertEquals("insufficient funds", e.getMessage());
        }
    }
}


