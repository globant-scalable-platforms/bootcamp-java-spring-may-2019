package com.bootcamp.bank;

import com.bootcamp.exceptions.TransferException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class StubAccountTransferTest {

    private AccountTransfer accountTransfer;

    //--------------Stub Testing---------------
    @Before
    public void setUp(){
        accountTransfer = new AccountTransfer(3000, 1500);
    }

    @Test
    public void validTransferFromCurrentToSavings() {

        Assert.assertEquals(true, accountTransfer.transferFromCurrentToSavings(2500));
        Assert.assertEquals(500, accountTransfer.getAccountCurrent(), 0.0001);
        Assert.assertEquals(4000, accountTransfer.getAccountSavings(), 0.0001);

    }

    @Test(expected = TransferException.class)
    public void invalidTransferFromCurrentToSavings() {

        accountTransfer.transferFromCurrentToSavings(3500);

    }
}