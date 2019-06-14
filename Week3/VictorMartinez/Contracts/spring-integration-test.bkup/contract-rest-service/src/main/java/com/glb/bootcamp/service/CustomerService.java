package com.glb.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

import com.glb.bootcamp.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final Map<Long, Customer> customers;
	private Customer customer;

	public CustomerService() {
		customers = new HashMap<>();
		customers.put(1L, new Customer(1L, "Mike", "Castro"));
		customers.put(2L, new Customer(2L, "Mauro", "Perez"));
		customers.put(3L, new Customer(3L, "Daniel", "Pelaez"));

		// Virtual Added customer
		//customers.put(4L, new Customer(4L, "William", "Diaz");
		//customers.put(5L, new Customer(5L, "Luis", "Jackson");

		// Virtual Updated customer
		//customers.put(5L, new Customer(5L, "Luis", "Jaimes");
	}
	
	public Customer findCustomerById(Long id) {
		return customers.get(id);
	}

	public Customer addCustomerById(Customer customer) {
		this.customers.put(customer.getId(), customer);
		return this.customers.get(customer.getId());
	}

	public Customer addCustomerByName(Customer customer) {
		this.customers.put(customer.getId(),customer);
		return this.customers.get(customer.getId());
	}

	public Customer setCustomerById(Long id, Customer customer){
		return this.customers.get(id).copy(customer);
	}

	public Customer setCustomerByName(Customer customer){
		return this.customers.get(customer.getId()).copy(customer);
	}

}
