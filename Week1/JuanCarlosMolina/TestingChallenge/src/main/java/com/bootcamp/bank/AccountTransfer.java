package com.bootcamp.bank;

import com.bootcamp.exceptions.TransferException;
import com.bootcamp.interfaces.Transfer;

public class AccountTransfer implements Transfer {

    private double accountCurrent;
    private double accountSavings;
    private double accountBalance;

    public AccountTransfer(double accountCurrent, double accountSavings) {
        this.accountCurrent = accountCurrent;
        this.accountSavings = accountSavings;
        this.accountBalance = accountCurrent + accountSavings;
    }

    public boolean transferFromCurrentToSavings(double amount) throws TransferException{

        if(amount < accountCurrent){

            accountCurrent -= amount;
            accountSavings += amount;
            //TODO Implement full logic and update database
            return true;
        }
        else
            throw new TransferException("Can´t transfer amount given");

    }

    @Override
    public boolean transferFromSavingsToCurren(double amount) throws TransferException {
        //TODO
        return false;
    }

    public double getAccountCurrent() {
        return accountCurrent;
    }

    public double getAccountSavings() {
        return accountSavings;
    }
}
