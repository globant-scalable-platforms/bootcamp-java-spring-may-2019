package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
    public String addCustomer(@RequestBody Customer customer){
        ResponseEntity<Customer> created = this.restTemplate.postForEntity("http://localhost:8000/customer", customer, Customer.class);
        return "Created user: " + created.getBody().getName();
    }
}
