package com.glb.bootcamp.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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


	public Long addCustomer(Customer customer){

		Long newId = customers.keySet()
								.stream()
								.max(Comparator.comparing(Long::valueOf))
								.get() + 1;

		customer.setId(newId);

		customers.put(newId, customer);

		return newId;
	}

	public Customer updateCustomer(Long id, Customer customer){

		if(Objects.nonNull(customers.get(id))){
			customers.put(id, customer);
		}

		return customers.get(id);
	}

	public Customer deleteCustomer(Long id){
		return customers.remove(id);
	}

}
