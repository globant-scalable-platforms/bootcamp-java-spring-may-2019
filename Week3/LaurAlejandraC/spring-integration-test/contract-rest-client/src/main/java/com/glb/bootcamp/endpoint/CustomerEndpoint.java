package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @PostMapping("/customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        try{
            ResponseEntity<Customer> created = this.restTemplate.postForEntity("http://localhost:8000/customer", customer, Customer.class);

            return new ResponseEntity<>("Created user: " + created.getBody().getName(), HttpStatus.CREATED);
        }
        catch (Exception ex){
            return new ResponseEntity<>("User was not created.", HttpStatus.BAD_REQUEST);
        }
    }
}
