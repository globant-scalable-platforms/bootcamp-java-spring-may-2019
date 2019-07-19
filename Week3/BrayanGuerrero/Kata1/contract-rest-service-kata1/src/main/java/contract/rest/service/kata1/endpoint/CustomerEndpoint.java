/**
 * 
 */
package contract.rest.service.kata1.endpoint;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(value="/createCustomer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer newCustomer) {
		try {
//			return customerService.saveCustomer(newCustomer);
			return ResponseEntity
				      .status(HttpStatus.CREATED)
				      .body(customerService.saveCustomer(newCustomer));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
	}

}
