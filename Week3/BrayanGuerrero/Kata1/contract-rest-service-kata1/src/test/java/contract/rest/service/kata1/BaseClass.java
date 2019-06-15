/**
 * 
 */
package contract.rest.service.kata1;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import contract.rest.service.kata1.endpoint.CustomerEndpoint;
import contract.rest.service.kata1.model.Customer;
import contract.rest.service.kata1.service.CustomerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author brayanguerrero
 *
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
		
		Mockito.when(customerService.saveCustomer(new Customer(4L, "Bryan", "Guerrero")))
				.thenReturn(new Customer(4L, "Bryan", "Guerrero"));
	}

}
