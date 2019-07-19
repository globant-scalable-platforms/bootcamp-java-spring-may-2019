package com.globant.bootcamp.spring.springcore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globant.bootcamp.spring.springcore.data.CustomAccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCoreApplicationTests {

	@Autowired
    private CustomAccountRepository retriever;

    @Test
    public void wellcomeUser() throws Exception {
    	assertEquals(retriever.retrieveAccountInformation("Penny", "Lizard"), "Wellcome");
    }
    
    @Test
    public void wrongPassword() throws Exception {
    	assertEquals(retriever.retrieveAccountInformation("Penny", "sdafsdf"), "Wrong Password");
    }
    
    @Test
    public void newUser() throws Exception {
    	assertEquals(retriever.retrieveAccountInformation("Mojojo", "sdafsdf"), "Successfully Register");
    }

}
