package com.bootcamp.bank;

import com.bootcamp.exceptions.TransferException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class MockAccountTransferTest {

    AccountTransfer accountTransfer;

    @Before
    public void setup(){
        accountTransfer = Mockito.mock(AccountTransfer.class);

    }

    @Test
    public void validTransferFromCurrentToSavings() {
        /*
        Scenario
        | account | balance |
        | current | 100 |
        | savings | 200 |
        */
        when(accountTransfer.transferFromCurrentToSavings(50)).thenReturn(true);
        Assert.assertEquals(true,accountTransfer.transferFromCurrentToSavings(50));
    }

    @Test
    public void invalidTransferFromCurrentToSavings() {

        /*
        Scenario
        | account | balance |
        | current | 100 |
        | savings | 200 |
        */
        when(accountTransfer.transferFromCurrentToSavings(400))
                            .thenThrow(new TransferException(""));
    }
}
