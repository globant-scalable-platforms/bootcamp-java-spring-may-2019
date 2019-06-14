package com.glb.bootcamp;

import com.glb.bootcamp.endpoint.CustomerEndpoint;
import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * To verify an API provider (the Spring controller in our case), Spring Cloud Contract automatically generates JUnit
 * tests from a given contract. In order to give these automatically generated tests a working context, we need to
 * create a base test class which is subclassed by all generated tests:
 *
 * In this base class, we’re setting up a Spring Boot application with @SpringBootTest and are mocking away the
 * CustomerService so that it always returns the person specified in the contract. Then, we set up RestAssured so that the
 * generated tests can simply use RestAssured to send requests against our controller.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractRestServiceApplication.class)
public abstract class BaseClass {

	@Autowired
	private CustomerEndpoint customerEndpoint;

	@MockBean
	private CustomerService customerService;

	@Before public void setup() {
		RestAssuredMockMvc.standaloneSetup(customerEndpoint);

		Mockito.when(customerService.findCustomerById(1L))
				.thenReturn(new Customer(1L, "Mike", "Castro"));


		Mockito.when(customerService.findCustomerById(2L))
				.thenReturn(new Customer(2L, "Mauro", "Perez"));


		Mockito.when(customerService.findCustomerById(3L))
				.thenReturn(new Customer(3L, "Daniel", "Pelaez"));

		Mockito.when(customerService.addCustomerById(new Customer(4L,"William", "Diaz")))
				.thenReturn(new Customer(4L, "William", "Diaz"));

		Mockito.when(customerService.addCustomerByName(new Customer(5L,"Luis", "Jackson")))
				.thenReturn(new Customer(5L, "Luis", "Jackson"));

		Mockito.when(customerService.setCustomerById(5L, new Customer(5L,"Luis", "Jackson")))
				.thenReturn(new Customer(5L, "Luis", "Jaimes"));

		Mockito.when(customerService.setCustomerByName(new Customer(7L,"Mike", "Castro")))
				.thenReturn(new Customer(7L, "Mike", "Castro"));

	}

}
