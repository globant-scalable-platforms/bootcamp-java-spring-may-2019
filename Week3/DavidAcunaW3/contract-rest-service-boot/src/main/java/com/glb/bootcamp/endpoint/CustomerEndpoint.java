package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerEndpoint {

	private final CustomerService customerService;

	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public ResponseEntity<Map<Long, Customer>> getCustomers() {
		try {
			return ResponseEntity.status(HttpStatus.OK)
			.body(customerService.getCustomers());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		try {
			if(customerService.createCustomer(customer)!=null) {
				return ResponseEntity.status(HttpStatus.CREATED)
				.body(customer);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		try {
			if(customerService.updateCustomer(id, customer) != null) {
				return ResponseEntity.status(HttpStatus.OK)
				.body(customer);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
		try {
			if(customerService.deleteCustomer(id) != null) {
				return ResponseEntity.status(HttpStatus.OK)
				.body(null);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
