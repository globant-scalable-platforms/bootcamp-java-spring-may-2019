package com.glb.bootcamp.service;

import com.glb.bootcamp.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

	private final Map<Long, Customer> customers;
	private long lastId;
	
	public CustomerService() {
		customers = new HashMap<>();
		customers.put(1L, new Customer(1L, "Mike", "Castro"));
		customers.put(2L, new Customer(2L, "Mauro", "Perez"));
		customers.put(3L, new Customer(3L, "Daniel", "Pelaez"));

		lastId = 3L;
	}
	
	public Customer findCustomerById(Long id) {
		return customers.get(id);
	}

	public Customer createNewCustomer(String name, String surname){

		lastId++;
		Customer customer = new Customer(lastId, name, surname);
		customers.put(lastId, customer);

		return customer;
	}
}
