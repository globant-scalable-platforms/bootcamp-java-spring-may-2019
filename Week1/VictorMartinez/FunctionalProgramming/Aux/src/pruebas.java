import java.util.HashMap;
import java.util.Map;

public class pruebas {

	public static void main(String [] args) {
		
		customers cus = new customers();
		
	
	
		cus.printCustomer();
		cus.addNewCustomer(new Customer(4L, "Loreno", "Silvano"));
		cus.printCustomer();
	}	
		
	
}
