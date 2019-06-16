package com.glb.bootcamp.service;

import com.glb.bootcamp.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

	public Customer findCustomerByName(String name) {
		List<Long> filteredKeyMap = customers.entrySet()
				.stream()
				.filter(entry -> Objects.equals(entry.getValue(), name))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		return customers.get(filteredKeyMap.get(0));
	}

	public Map<Long, Customer> getCustomers(){
		return this.customers;
	}
}
