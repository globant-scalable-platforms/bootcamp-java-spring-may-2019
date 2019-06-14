package com.glb.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

import com.glb.bootcamp.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final Map<Long, Customer> customers;
	private Long idCounter = 0L;
	
	public CustomerService() {
		customers = new HashMap<>();
		customers.put(1L, new Customer(1L, "Mike", "Castro"));
		customers.put(2L, new Customer(2L, "Mauro", "Perez"));
		customers.put(3L, new Customer(3L, "Daniel", "Pelaez"));
		this.idCounter = customers.size() + 0L;
	}
	
	public Map<Long, Customer> getAll(){
		return customers;
	}
	
	public Customer findCustomerById(Long id) {
		return customers.get(id);
	}
	
	public Customer createCustomer(String name, String surname) {
		idCounter = idCounter + 1L;
		customers.put(idCounter, new Customer(idCounter, name, surname));
		return customers.get(idCounter);
	}
	
	public void deleteCustomer(Long id) {
		customers.remove(id);
	}
	
	public void updateCustomer(Long id, String name, String surname) {
		customers.get(id).setName(name);
		customers.get(id).setSurname(surname);
	}
}
