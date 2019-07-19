package com.globant.bootcamp.spring.springcore.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.bootcamp.spring.springcore.data.AccountRepository;
import com.globant.bootcamp.spring.springcore.domain.Account;

@Service
public class AuthenticatorImpl implements Authenticator{
    
    private AccountRepository accountRepository;

    @Autowired
    public AuthenticatorImpl(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    
    public boolean authenticate(final String username, final String password){
        try {
            final Account account = accountRepository.getAccount(username);
            return account.getPassword().equals(password);
        } catch (NullPointerException e) {
            return false;
        }
    }
}
