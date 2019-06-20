package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		if(customerService.addCustomer(customer) != null) {
			return new ResponseEntity<>(customer, HttpStatus.CREATED);
		}

		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
