package com.bootcamp.restapp.RestExample;

import com.bootcamp.restapp.RestExample.data.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import javax.xml.crypto.Data;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestExampleApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	public void getDataSourceContent() {
		Assert.assertTrue(Objects.nonNull(dataSource.getStudents()));
	}



}
