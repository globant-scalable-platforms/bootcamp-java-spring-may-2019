package com.globant.bootcamp.spring.springcore.domain;

import java.util.ArrayList;

public class DataSource {

    private static ArrayList<Account> collection;

    public DataSource() {
        collection = new ArrayList<>();
        Account a = new Account("Andres", "Secret");
        Account b = new Account("Camilo", "Secret");
        collection.add(a);
        collection.add(b);
    }


    public Account retrieveAccountInformation(String username) {

        Account n = null;
        boolean created = false;

        for (Account x : collection) {
            if (username.equals(x.getUsername())) {
                created = true;
                n = x;
                break;
            }
        }

        if (!created) {
            n = new Account(username, "Secret");
            collection.add(n);
            //System.out.println(collection);
        }

        return n;

    }

}
