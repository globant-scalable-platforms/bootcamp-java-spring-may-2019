package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static List<Account> users;

    public DataSource(){
        users = new ArrayList<>();
        users.add(new Account("Diego","diego"));
        users.add(new Account("Messi","messi"));
        users.add(new Account("Puyol","puyol"));
        users.add(new Account("Alves","alves"));
        users.add(new Account("Iniesta","iniesta"));
    }

    public Account retrieveUserInformation(String username){
        Account user = users.stream().filter(a -> a.getUsername().equals(username))
        .findFirst().orElse(null);

        return user == null ? null : new Account(user.getUsername(), user.getPassword());
    }

}