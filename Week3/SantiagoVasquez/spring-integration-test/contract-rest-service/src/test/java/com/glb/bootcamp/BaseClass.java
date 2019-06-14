package com.glb.bootcamp;

import com.glb.bootcamp.endpoint.CustomerEndpoint;
import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * To verify an API provider (the Spring controller in our case), Spring Cloud Contract automatically generates JUnit
 * tests from a given contract. In order to give these automatically generated tests a working context, we need to
 * create a base test class which is subclassed by all generated tests:
 * <p>
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

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(customerEndpoint);

        Mockito.when(customerService.findCustomerById(1L))
                .thenReturn(new Customer(1L, "Mike", "Castro"));

        Mockito.when(customerService.createCustomer("Santi", "Vasquez"))
                .thenReturn(new Customer(4L, "Santi", "Vasquez"));
    }

}
