package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataSourceTest {

    private DataSourceInterface dataSource;

    @Before
    public void setUp() {
        dataSource = new StaticDataSource();
    }

    @Test
    public void getAnExistingAccount() {
        String username = "Mike";

        final Account account = dataSource.retrieveUserInformation(username);
        Assert.assertEquals(account.getUsername(), username);
        Assert.assertEquals(account.getPassword(), "123456");
    }

    @Test
    public void getANonExistingAccount() {
        String username = "Chimuelo";

        final Account account = dataSource.retrieveUserInformation(username);
        Assert.assertEquals(account.getUsername(), username);
        Assert.assertEquals(account.getPassword().length(), 6);
    }
}
