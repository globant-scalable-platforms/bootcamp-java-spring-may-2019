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

		return (customers.containsKey(id))? customers.get(id): new Customer(0L, "-","-");
	}

	public Customer findCustomerByName(String name) {
		for (Map.Entry<Long, Customer> entry : this.customers.entrySet()) {
			if (entry.getValue().getName().equalsIgnoreCase(name)){
				return customers.get(entry.getKey());
			}
		}
		return null;
	}

	public Map<Long, Customer> getCustomers(){
		return this.customers;
	}

	public Customer addNewCustomer(Customer customer){

		 //customers.put(customer.getId(), new Customer(customer.getId(), customer.getName(), customer.getSurname()));
		customers.put(customer.getId(),customer);
		return customers.get(customer.getId());

	}

	public Customer updateCustomer(Long userId, Customer customer){
		customers.put(userId, customer);
		return customers.get(userId);
	}

	public Customer deletedCustomer(Long userId){
		try {
			this.customers.remove(userId);
		}catch (Exception ex){
			return new Customer (0L,"-","-");
		}
		return (!customers.containsKey(userId))? new Customer(0L, "-","-"): customers.get(userId);
	}
}
