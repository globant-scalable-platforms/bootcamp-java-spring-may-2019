/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.spring.springcore.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Collazos Barrera
 */
public class DataSource {
    
    private static List<Account> accounts;
    
    public DataSource() {
        initAccounts();
    }
    
    private void initAccounts(){
        accounts = new ArrayList<Account>();
        accounts.add(new Account("Globant","bootcamp159"));
        accounts.add(new Account("Google","USBranch"));
        accounts.add(new Account("IBM","non92"));
        accounts.add(new Account("Oracle","2010?*"));
        accounts.add(new Account("Space","m1.-23"));
        accounts.add(new Account("Microsoft","ver45.-1"));
        accounts.add(new Account("Lux","m87wj"));
        accounts.add(new Account("Mercedes","H90"));
    }
    
    public Account retrieveAccountInformation(String username){
        
        Account account = accounts.stream()
                .filter(a -> username.equals(a.getUsername()))
                .findFirst()
                .orElse(null);
        
        return account!=null ? new Account(account.getUsername(),account.getPassword()) : null;
    }
}
