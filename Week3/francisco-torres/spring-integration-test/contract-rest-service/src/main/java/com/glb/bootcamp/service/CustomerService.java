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
		if (!customers.containsKey(id)) {
			return null;
		}

		return customers.get(id);
	}

	public boolean createCustomer(Customer customer) {
		if(customers.containsKey(customer.getId())) {
			return false;
		}

		customers.put(customer.getId(),customer);
		return true;
	}

	public boolean updateCustomer(Long id, Customer customer) {
		if(!id.equals(customer.getId())) {
			return false;
		}

		customers.put(id, customer);
		return true;
	}

	public boolean deleteCustomer(Long id) {
		customers.remove(id);
		return true;
	}
}
