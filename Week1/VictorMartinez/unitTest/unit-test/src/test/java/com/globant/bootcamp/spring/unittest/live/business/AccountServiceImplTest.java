package com.globant.bootcamp.spring.unittest.live.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import springbootcamp.unittest.kata.business.AccountServiceImpl;
import springbootcamp.unittest.kata.data.AccountRepository;
import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;
import springbootcamp.unittest.kata.domain.TransferResponse;
import org.springframework.boot.test.rule.OutputCapture;
import javax.security.auth.login.AccountException;

import static org.mockito.Mockito.*;

public class AccountServiceImplTest {
    @Mock
    private AccountRepository accountRepository;

    private AccountServiceImpl service;

    private String usernameCurrent;
    private String usernameSaving;



    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        service = new AccountServiceImpl(accountRepository);
        usernameCurrent = "Mikel";
        usernameSaving  = "Mauro";
        when(accountRepository.findAccountByUsernameAndType(usernameCurrent, AccountType.CURRENT)).thenReturn(new Account(usernameCurrent, 3000, AccountType.CURRENT));
        when(accountRepository.findAccountByUsernameAndType(usernameSaving, AccountType.SAVING)).thenReturn(new Account(usernameSaving, 1500, AccountType.SAVING));
    }

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void shouldPass(){

        boolean countDisponibility = service.checkCapacity(usernameCurrent, usernameSaving);
        Assert.assertTrue(countDisponibility);
        try {
            TransferResponse response = service.transferMoney(service.retrieveAccount(usernameCurrent, AccountType.CURRENT), service.retrieveAccount(usernameSaving, AccountType.SAVING), 2500);

        }
        catch(AccountException e){
            e.printStackTrace();
        }

        Assert.assertEquals(500,service.retrieveAccount(usernameCurrent, AccountType.CURRENT).getBalance());
        Assert.assertEquals(4000,service.retrieveAccount(usernameSaving, AccountType.SAVING).getBalance());

    }

    @Before
    public void setUp2() throws Exception{
        MockitoAnnotations.initMocks(this);
        service = new AccountServiceImpl(accountRepository);
        usernameCurrent = "Mikel";
        usernameSaving  = "Mauro";
        when(accountRepository.findAccountByUsernameAndType(usernameCurrent, AccountType.CURRENT)).thenReturn(new Account(usernameCurrent, 100, AccountType.CURRENT));
        when(accountRepository.findAccountByUsernameAndType(usernameSaving, AccountType.SAVING)).thenReturn(new Account(usernameSaving, 200, AccountType.SAVING));
    }

    @Test
    public void shouldFail(){

        boolean countDisponibility = service.checkCapacity(usernameCurrent, usernameSaving);
        Assert.assertTrue(countDisponibility);
        try {
            TransferResponse response = service.transferMoney(service.retrieveAccount(usernameCurrent, AccountType.CURRENT), service.retrieveAccount(usernameSaving, AccountType.SAVING), 2500);

        }
        catch(AccountException e){
            e.printStackTrace();
        }

        Assert.assertEquals(500,service.retrieveAccount(usernameCurrent, AccountType.CURRENT).getBalance());
        Assert.assertEquals(4000,service.retrieveAccount(usernameSaving, AccountType.SAVING).getBalance());

    }




}
