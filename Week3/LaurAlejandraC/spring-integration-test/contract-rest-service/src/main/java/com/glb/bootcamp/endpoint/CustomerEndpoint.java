package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerEndpoint {

	private final CustomerService customerService;

	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customer")
	public List<Customer> getAllCustomers(){
		return customerService.getCustomersList();
	}

	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);

		/*if(customerService.addCustomer(customer).is2xxSuccessful())
			return new ResponseEntity<>(customer, HttpStatus.CREATED);

		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);*/
	}
}
