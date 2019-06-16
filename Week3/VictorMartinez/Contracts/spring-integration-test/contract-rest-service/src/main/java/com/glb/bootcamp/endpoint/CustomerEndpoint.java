package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomerEndpoint {

	private final CustomerService customerService;

	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(value = "/customer/id/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}

	@GetMapping(value = "/customer/name/{name}",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer findCustomerById(@PathVariable("name") String userName) {
		return customerService.findCustomerByName(userName);
	}

	@GetMapping(value = "/customer",
	produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<Long, Customer> getAllCustomers(){
		return customerService.getCustomers();
	}
}
