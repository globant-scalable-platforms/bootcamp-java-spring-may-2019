package com.glb.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

import com.glb.bootcamp.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final Map<Long, Customer> customers;
	
	public CustomerService() {
		customers = new HashMap<>();
		customers.put(1L, new Customer(1L, "Mike", "Castro"));
		customers.put(2L, new Customer(2L, "Mauro", "Perez"));
		customers.put(3L, new Customer(3L, "Daniel", "Pelaez"));
	}
	
	public Customer findCustomerById(Long id) {
		return customers.get(id);
	}

	public boolean addCustomer(Customer customer){
		if(customers.containsKey(customer.getId())) {
			return false;
		}
		else{
			customers.put(customer.getId(), customer);
			return true;
		}
	}
}
