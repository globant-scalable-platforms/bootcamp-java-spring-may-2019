package com.bootcamp.interfaces;

public interface Transfer {
    public boolean transferFromCurrentToSavings(double amount);

    public boolean transferFromSavingsToCurren(double amount);
}
