package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.Base.requestMin;
import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerEndpoint {

	private final CustomerService customerService;
	private requestMin request;

	@Autowired
	public CustomerEndpoint(CustomerService customerService, requestMin request) {
		this.customerService = customerService;
		this.request = request;
	}

	@GetMapping(value = "/customer/id/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}

	@RequestMapping(value = "/customer/name/{username}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer findCustomerByNames(@PathVariable String username) {
		//System.out.println("name "+ username);
		//return username;
		return this.customerService.findCustomerByName(username);
		//return this.customerService.findCustomerById(a);
	}

	@GetMapping(value = "/customer",
	produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<Long, Customer> getAllCustomers(){
		return customerService.getCustomers();
	}


	@PostMapping(value = "/customer/id",
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer addNewCustomer(@RequestBody Customer customer){

		return this.customerService.addNewCustomer(customer);

	}

	@PutMapping(value = "/customer/id/{userId}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateOldCustomer(@PathVariable("userId") Long userId, @RequestBody Customer customer){

		return this.customerService.updateCustomer(userId, customer);

	}

}
