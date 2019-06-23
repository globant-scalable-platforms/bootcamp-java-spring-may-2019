package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
public class CustomerEndpoint {

	private final CustomerService customerService;

	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{id}")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer){

		Customer newCustomer = customerService.addCustomer(customer);

		if(Objects.nonNull(newCustomer)){
			return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}
}
