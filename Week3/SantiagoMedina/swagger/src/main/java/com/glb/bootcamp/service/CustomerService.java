package com.glb.bootcamp.service;

import java.util.Map;

import com.glb.bootcamp.model.Customer;

import io.swagger.annotations.ApiOperation;

public interface CustomerService {

	@ApiOperation(value = "Get all Customers in the System ", response = Iterable.class, tags = "getAll")
	Map<Long, Customer> getAll();
	
	@ApiOperation(value = "Get specific Customer by id in the System ", response = Customer.class, tags = "findCustomerById")
	Customer findCustomerById(Long id);
	
	@ApiOperation(value = "Create a Customer in the System ", response = Customer.class, tags = "createCustomer")
	Customer createCustomer(String name, String surname);
	
	@ApiOperation(value = "Delete a Customer by id in the System ", response = Void.class, tags = "deleteCustomer")
	void deleteCustomer(Long id);
	
	@ApiOperation(value = "Update a Customer by id in the System ", response = Void.class, tags = "updateCustomer")
	void updateCustomer(Long id, String name, String surname);
	
}
