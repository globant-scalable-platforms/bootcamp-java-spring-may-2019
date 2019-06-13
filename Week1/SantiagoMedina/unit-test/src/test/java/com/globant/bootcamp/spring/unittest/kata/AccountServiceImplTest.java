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
    

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        try{
            Constructor<Account> buildAccount = Account.class.getDeclaredConstructor(String.class, int.class, AccountType.class);
            buildAccount.setAccessible(true);
            currentAccount = buildAccount.newInstance("Santiago",0,AccountType.CURRENT);
            savingAccount = buildAccount.newInstance("Felipe",0,AccountType.SAVING);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        when(accountRepository.findAccountByUsernameAndType("Santiago", AccountType.CURRENT)).thenReturn(currentAccount);
        when(accountRepository.updateAccount(currentAccount)).thenReturn(currentAccount);

        when(accountRepository.findAccountByUsernameAndType("Felipe", AccountType.SAVING)).thenReturn(savingAccount);
        when(accountRepository.updateAccount(savingAccount)).thenReturn(savingAccount);
    }

    @Test
    public void transferMoneyCurrentToSaving() {
        
        int balanceCurrentAccount = 3000;
        int balanceSavingAccount = 1500;
        int transferAmount = 2500;

        currentAccount.setBalance(balanceCurrentAccount);
        savingAccount.setBalance(balanceSavingAccount);

        try {
            accountService.transferMoney(currentAccount,savingAccount,transferAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assert.assertTrue(currentAccount.getBalance() == (500));
        Assert.assertTrue(savingAccount.getBalance() == (4000));
    }

    @Test
    public void transferMoneyCurrentToSavingInsufficientFunds() {
        int balanceCurrentAccount = 100;
        int balanceSavingAccount = 200;
        int transferAmount = 400;

        currentAccount.setBalance(balanceCurrentAccount);
        savingAccount.setBalance(balanceSavingAccount);

        try {
            accountService.transferMoney(currentAccount,savingAccount,transferAmount);
        } catch (Exception e) {
            Assert.assertEquals("insufficient funds", e.getMessage());
        }
    }

}