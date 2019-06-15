/**
 * 
 */
package contract.rest.service.kata1.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contract.rest.service.kata1.model.Customer;
import contract.rest.service.kata1.service.CustomerService;

/**
 * @author brayanguerrero
 *
 */
@RestController
public class CustomerEndpoint {
	
	private final CustomerService customerService;

	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}
	
	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestBody Customer newCustomer) {
		return customerService.saveCustomer(newCustomer);
	}

}
