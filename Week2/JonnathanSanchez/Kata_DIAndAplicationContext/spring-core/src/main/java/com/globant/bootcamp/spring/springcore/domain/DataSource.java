package com.globant.bootcamp.spring.springcore.domain;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static List<Account> accounts = new ArrayList<>();

    public DataSource(){
        accounts.add(new Account("jonnathan", "1234"));
        accounts.add(new Account("alejandro", "2345"));
        accounts.add(new Account("andrea", "4567"));
        accounts.add(new Account("paula", "7890"));
        accounts.add(new Account("medina", "0000"));
    }

    public Account retrieveUserInformation(String username){
        Account account = accounts.stream().filter(a -> a.getUsername().equals(username)).findAny().orElse(null);
        return  account;

    }

}
