package com.globant.bootcamp.spring.springcore.business;

import com.globant.bootcamp.spring.springcore.data.AccountRepository;
import com.globant.bootcamp.spring.springcore.data.DataSource;
import com.globant.bootcamp.spring.springcore.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HelloWorldImpl implements HelloWorld {

    private DataSource dataSource;

    @Autowired
    public HelloWorldImpl(final DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void printGreeting(String username) {

    }
}




