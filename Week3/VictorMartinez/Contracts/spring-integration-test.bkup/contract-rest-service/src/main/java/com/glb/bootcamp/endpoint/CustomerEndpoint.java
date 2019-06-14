package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerEndpoint {

	private final RestTemplate restTemplate;
	private final CustomerService customerService;


	public CustomerEndpoint(CustomerService customerService, RestTemplate restTemplate) {
		this.customerService = customerService;
		this.restTemplate = restTemplate;
	}

	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}

	@PostMapping(value = "/customer/", consumes = "application/json", produces = "application/json")
	public Customer addCustomerById(@RequestBody Customer customer) {
		Customer newCustomer = this.restTemplate.getForObject("http://localhost:8000/customer/", Customer.class);
		customerService.addCustomerById(newCustomer);
		return customerService.findCustomerById(newCustomer.getId());
	}

	@PostMapping(value = "/customer/{name}", consumes = "application/json", produces = "application/json")
	public Customer addCustomerByName(@RequestBody Customer customer) {
		Customer newCustomer = this.restTemplate.getForObject("http://localhost:8000/customer/{name}", Customer.class);
		return customerService.addCustomerByName(newCustomer);
	}

	@PutMapping(value = "/customer/{id}", consumes = "application/json", produces = "application/json")
	public Customer updateCustomerById(@RequestBody Customer customer) {
		Customer updatedCustomer = this.restTemplate.getForObject("http://localhost:8000/customer/{id}", Customer.class);
		return customerService.setCustomerById(updatedCustomer.getId(), updatedCustomer);
	}

	@PutMapping(value = "/customer/{name}", consumes = "application/json", produces = "application/json")
	public Customer updateCustomerByName(@RequestBody Customer customer) {
		Customer updatedCustomer = this.restTemplate.getForObject("http://localhost:8000/customer/{name}", Customer.class);
		return customerService.setCustomerByName(updatedCustomer);
	}
}
