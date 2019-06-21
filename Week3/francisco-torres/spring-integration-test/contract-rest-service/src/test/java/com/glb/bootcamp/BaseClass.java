package com.glb.bootcamp;

import com.glb.bootcamp.endpoint.CustomerEndpoint;
import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractRestServiceApplication.class)
public abstract class BaseClass {

	@Autowired
	private CustomerEndpoint customerEndpoint;

	@MockBean
	private CustomerService customerService;

	@Before
	public void setup() {
		given(customerService.createCustomer(argThat(a -> a.getId() >= 4)))
				             .willReturn(true);

		given(customerService.findCustomerById(eq(1L)))
				             .willReturn(new Customer(1L, "Mike", "Castro"));

		given(customerService.findCustomerById(eq(2L)))
				             .willReturn(new Customer(2L, "Mauro", "Perez"));

		given(customerService.updateCustomer(eq(2L), argThat(a -> a.getId() == 2L)))
				             .willReturn(true);

		given(customerService.deleteCustomer(eq(1L)))
							 .willReturn(true);

		RestAssuredMockMvc.standaloneSetup(customerEndpoint);
	}
}
