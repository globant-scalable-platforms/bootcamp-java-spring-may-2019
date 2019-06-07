package com.globant.bootcamp.spring.springcore.domain;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static List<Account> account;

    public DataSource(List<Account> account) {
        this.account = account;
    }

    public Account retrieveAccountInformation(String username) {
        for (Account object: account) {
            if(object.getUsername().equals(username)) {
                return object;
            }
        }

        return null;
    }
}
