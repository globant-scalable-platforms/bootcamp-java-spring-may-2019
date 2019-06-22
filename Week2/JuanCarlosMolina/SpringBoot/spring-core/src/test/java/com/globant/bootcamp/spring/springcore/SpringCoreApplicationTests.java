package com.globant.bootcamp.spring.springcore;

import com.globant.bootcamp.spring.springcore.business.Authenticator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCoreApplicationTests {

	@Autowired
	Authenticator authenticator;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPassAuthenticator(){

		String username = "Juan";
		String password = "RM1280";

		Assert.assertTrue(authenticator.authenticate(username,password));
	}

	@Test
	public void testFailedAuthenticator(){

		String username = "Juan";
		String password = "1280";

		Assert.assertFalse(authenticator.authenticate(username,password));
	}

}
