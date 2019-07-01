package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.model.CustomerRequest;
import com.glb.bootcamp.service.CustomerService;

import io.swagger.annotations.Api;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "CustomerEndpointController")
@RestController
@RequestMapping("/customers")
public class CustomerEndpoint {

	private final CustomerService customerService;

	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public Map<Long, Customer> getAll(){
		return customerService.getAll();
	}

	@GetMapping("/{id}")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}
	
	@PostMapping
	public Customer createCustomer(@RequestBody @Valid CustomerRequest customer) {
		return customerService.createCustomer(customer.getName(), customer.getSurname());
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
	}
	
	@PutMapping("/{id}")
	public void updateCustomer(@PathVariable("id") Long id, @RequestBody @Valid CustomerRequest customer) {
		customerService.updateCustomer(id, customer.getName(), customer.getSurname());
	}
	
	
}
