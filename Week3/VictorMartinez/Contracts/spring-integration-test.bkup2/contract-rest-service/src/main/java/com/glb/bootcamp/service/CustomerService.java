package com.glb.bootcamp.service;

import com.glb.bootcamp.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
		Long keySearched = null;
		for(Customer customer : customers.values()){
			if(customer.getName() == name){
				keySearched = customer.getId();
			}
		}
		return customers.get(keySearched);
	}

	public Customer addCustomerByName(Customer customer){
		this.customers.put(customer.getId(), customer);
		return customers.get(customer.getId());
	}
	public Customer addCustomerById(Customer customer){
		this.customers.put(customer.getId(), customer);
		return customers.get(customer.getId());
	}
	public boolean validAddRequest(Customer customer){
		return (customer.getName()!="" && customer.getId()!=0
		&& !customers.containsKey(customer.getId())&& customer.getSurname()!="")?true:false;
	}

	public Customer updateCustomerById(Long userId, Customer customer){
		return this.customers.get(userId).updateCustomer(customer);
	}

}
