package com.globant.bootcamp.spring.springcore;

import com.globant.bootcamp.spring.springcore.data.DataSource;
import com.globant.bootcamp.spring.springcore.domain.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataSourceTest {
    private DataSource data;

    @Before
    public void setUp(){
        data = new DataSource();
    }

    @Test
    public void retrieveAccountInformation(){
        Account retrieved = data.retrieveAccountInformation("Laura");
        Assert.assertNotNull(retrieved);
        Assert.assertEquals("Laura", retrieved.getUsername());
        Assert.assertEquals("superSecret", retrieved.getPassword());
    }

    @Test
    public void retrieveNonExistentAccount(){
        Account retrieved = data.retrieveAccountInformation("OtherUser");
        Assert.assertNull(retrieved);
    }
}
