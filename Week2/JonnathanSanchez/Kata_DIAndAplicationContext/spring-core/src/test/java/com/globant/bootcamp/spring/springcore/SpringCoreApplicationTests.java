package com.globant.bootcamp.spring.springcore;

import com.globant.bootcamp.spring.springcore.domain.DataSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCoreApplicationTests {

	private DataSource dataSource;

	@Before
	public void setup(){
		dataSource = new DataSource();
	}

	@Test
	public void retrieveUserInformation() {
		Assert.assertNotNull(dataSource.retrieveUserInformation("jonnathan"));
		Assert.assertNull(dataSource.retrieveUserInformation("maria"));
	}

}
