package com.glb.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

import com.glb.bootcamp.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final Map<Integer, Customer> customers;
	
	public CustomerService() {
		customers = new HashMap<>();
		customers.put(1, new Customer(1, "Mike", "Castro"));
		customers.put(2, new Customer(2, "Mauro", "Perez"));
		customers.put(3, new Customer(3, "Daniel", "Pelaez"));
	}
	
	public Customer findCustomerById(int id) {
		return customers.get(id);
	}
	
	public Customer newCostumer(Customer customer) {
		customers.put(customer.getId(), customer);
		return customers.get(customer.getId());
	}
}
