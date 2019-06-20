import java.util.HashMap;
import java.util.Map;

public class customers {
	
private final Map<Long, Customer> customers;
	
	public customers() {
		customers = new HashMap<>();
		customers.put(1L, new Customer(1L, "Mike", "Castro"));
		customers.put(2L, new Customer(2L, "Mauro", "Perez"));
		customers.put(3L, new Customer(3L, "Daniel", "Pelaez"));
	}
	
	public Customer findCustomerById(Long id) {
		return customers.get(id);
	}
	
	public void printCustomer() {
		for(Customer custom : this.customers.values()) {
			System.out.println(custom.getName());
		}
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
		HashMap<Long,Customer> tempCustom = new HashMap<Long, Customer>(this.customers);
		tempCustom.put(customer.getId(), customer);
		this.customers = new HashMap<Long, Customer>(tempCustom);
		this.customers.put(customer.getId(), customer); return this.customers.get(customer.getId());

	public 
	}
	
	

}
