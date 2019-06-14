package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerEndpoint {

	private final CustomerService customerService;

	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") int id) {
		return customerService.findCustomerById(id);
	}
	
	@PostMapping("/customer")
	public Customer newCostumer(@RequestBody Customer customer) {
		System.out.println("Customer: "+customer.getName());
		Customer customResponse = customerService.newCostumer(customer);
		System.out.println("CustomerResponse: "+customResponse);
		return customResponse;
	}
}
