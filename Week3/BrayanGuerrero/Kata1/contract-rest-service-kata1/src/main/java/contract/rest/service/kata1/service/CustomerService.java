/**
 * 
 */
package contract.rest.service.kata1.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import contract.rest.service.kata1.model.Customer;

/**
 * @author brayanguerrero
 *
 */
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

	public Customer saveCustomer(Customer newCustomer) {
		customers.put(4L, newCustomer);
		return newCustomer;
	}
}