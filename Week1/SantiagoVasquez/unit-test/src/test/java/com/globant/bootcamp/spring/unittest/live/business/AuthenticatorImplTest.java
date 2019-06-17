package com.globant.bootcamp.spring.unittest.live.business;


import com.globant.bootcamp.spring.unittest.live.stubs.StubAccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import springbootcamp.unittest.live.business.AuthenticatorImpl;
import springbootcamp.unittest.live.data.AccountRepository;
import springbootcamp.unittest.live.domain.Account;

import static org.mockito.Mockito.*;

public class AuthenticatorImplTest{

    @Mock
    private AccountRepository accountRepository;

    private AuthenticatorImpl authenticator;

    private String username;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        authenticator = new AuthenticatorImpl(accountRepository);
        username = "Mike";
        when(accountRepository.getAccount(username)).thenReturn(new Account(username,"1234"));
    }

    @Test
    public void shouldPass() {

        boolean response = authenticator.authenticate("Mike", "1234");
        Assert.assertTrue(response);
        verify(accountRepository, times(2)).getAccount(username);
    }

    @Test
    public void shouldFail() {

        boolean response = authenticator.authenticate("Mike", "invalid");
        Assert.assertFalse(response);
    }
}
