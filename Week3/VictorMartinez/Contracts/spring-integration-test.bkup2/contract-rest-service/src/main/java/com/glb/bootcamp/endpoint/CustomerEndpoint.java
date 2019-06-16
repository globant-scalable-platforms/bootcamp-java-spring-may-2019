package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerEndpoint {

	private final CustomerService customerService;

	@Autowired
	private RestTemplate restTemplate;


	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;

	}

	@GetMapping(value = "/customer/id/{id}", produces = "application/json; charset=UTF-8")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}

	@GetMapping(value = "/customer/name/{name}", produces = "application/json; charset=UTF-8")
	public Customer findCustomerByName(@PathVariable("name") String userName) {
		return customerService.findCustomerByName(userName);
	}

	@RequestMapping(value ="/customer/name",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomerByName(@RequestBody(required = true) Customer customer){
		//return (customerService.validAddRequest(customer))?
		return customerService.addCustomerByName(customer);
				//new Customer();
	}

	@RequestMapping(value ="/customer/id",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomerById(@RequestBody Customer customer){
		//return (customerService.validAddRequest(customer))?
		return customerService.addCustomerById(customer);
				//new Customer();
	}


	@RequestMapping(value="/customer/id/{customerId}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces =MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomerById(@PathVariable("customerId") Long customerId, @RequestBody Customer customer){

		return customerService.updateCustomerById(customerId, customer);
	}


}
