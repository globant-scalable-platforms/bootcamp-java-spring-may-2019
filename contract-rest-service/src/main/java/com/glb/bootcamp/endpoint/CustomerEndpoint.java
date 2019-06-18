package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Api(value = "CustomerController")
@RestController
public class CustomerEndpoint {

	private final CustomerService customerService;

	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}

	@ApiOperation(value = "Get a list of Customer", response = Iterable.class, tags = "getCustomers")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Success|OK"))
	@GetMapping("/customers")
	public List<Customer> findAll(){
		return customerService.findAll();
	}

	@ApiOperation(value = "Get a customer by id", response = Customer.class, tags = "findCustomerById")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 404, message = "Not found!!!") })
	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}

	@ApiOperation(value = "Add a new customer", response = Customer.class, tags = "addCustomer")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping("/customers/")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){

		Long id = customerService.addCustomer(customer);

		if(id>0) return new ResponseEntity<>("id: " + id, HttpStatus.CREATED);

		return new ResponseEntity<>("Can´t save customer.", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ApiOperation(value = "Updates an existing customer", response = Customer.class, tags = "updateCustomer")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PutMapping("/customers/{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Customer customer){

		Customer updatedCustomer = customerService.updateCustomer(id, customer);

		if(Objects.nonNull(updatedCustomer))
			return ResponseEntity.status(HttpStatus.CREATED)
									.body(updatedCustomer);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can´t find customer with id: "+ id);
	}

	@ApiOperation(value = "Deletes an existing customer", response = Customer.class, tags = "deleteCustomer")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
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
