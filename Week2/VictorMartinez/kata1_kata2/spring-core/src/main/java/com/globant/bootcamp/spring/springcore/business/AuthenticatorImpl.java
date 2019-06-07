package com.globant.bootcamp.spring.springcore.business;

import com.globant.bootcamp.spring.springcore.data.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.globant.bootcamp.spring.springcore.data.AccountRepository;
import com.globant.bootcamp.spring.springcore.domain.Account;



@Service
public class AuthenticatorImpl implements Authenticator{
    
    private AccountRepository accountRepository;
    private DataSource dataSource;

    @Autowired
    public AuthenticatorImpl(final AccountRepository accountRepository, final DataSource dataSource) {
        this.accountRepository = accountRepository;
        this.dataSource        = dataSource;
    }

    
    public boolean authenticate(final String username, final String password){
        try {
            final Account account = accountRepository.getAccount(username);
            return account.getPassword().equals(password);
        } catch (NullPointerException e) {
            return false;
        }
    }


    public String retrieveAccount(final String username){
            final Account account = dataSource.retrieveUserInformation(username);
            return "Welcome to Globant user: " + account.getUsername() + " PassWord : " + account.getPassword();
    }
}
