package contract.rest.client.kata1.endpoint;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import contract.rest.client.kata1.model.Customer;

@RestController
public class CustomerEndpoint {

    private final RestTemplate restTemplate;

    public CustomerEndpoint(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping("/customer/{customerId}")
    public String getCustomer(@PathVariable("customerId") Long customerId) {
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/{customerId}", Customer.class, customerId);
        return "Welcome " + customer.getName();
    }
    
    @RequestMapping("/createCustomer")
    public String createCustomer(@RequestBody Customer newCustomer) {
    	Customer customer =
                this.restTemplate.postForEntity("http://localhost:8000/createCustomer", new Customer(4L, "Bryan", "Guerrero"), Customer.class).getBody();
        return "New Customer id "+customer.getId();
    }

}
