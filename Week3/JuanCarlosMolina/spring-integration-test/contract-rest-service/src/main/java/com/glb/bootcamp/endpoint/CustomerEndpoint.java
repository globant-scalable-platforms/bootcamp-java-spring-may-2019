package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

	@PostMapping("/customers/")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){

		Long id = customerService.addCustomer(customer);

		if(id>0) return new ResponseEntity<>("id: " + id, HttpStatus.CREATED);

		return new ResponseEntity<>("Can´t save customer.", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Customer customer){

		Customer updatedCustomer = customerService.updateCustomer(id, customer);

		if(Objects.nonNull(updatedCustomer))
			return ResponseEntity.status(HttpStatus.CREATED)
									.body(updatedCustomer);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can´t find customer with id: "+ id);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){

		Customer deletedCustomer = customerService.deleteCustomer(id);

		if(Objects.nonNull(deletedCustomer)){
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body(deletedCustomer);
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can´t find customer with id: "+ id);
	}
}
