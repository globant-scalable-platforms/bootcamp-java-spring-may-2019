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

	@PostMapping("/customers")
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
		if(!customerService.createCustomer(customer)) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(HttpStatus.CREATED);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id) {
		Customer customer = customerService.findCustomerById(id);

		if (customer == null) {
			return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		if(customerService.findCustomerById(id) == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		if(!customerService.updateCustomer(id,customer)) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable("id") Long id) {
		if(customerService.findCustomerById(id) == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		customerService.deleteCustomer(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
