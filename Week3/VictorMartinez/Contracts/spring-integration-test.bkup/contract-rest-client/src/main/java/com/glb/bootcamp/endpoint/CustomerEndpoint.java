package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
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

    @PostMapping("/customer/{id}")
    public String putCustomer(@PathVariable("id") Long id){
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/{id}", Customer.class, id);
        return "Added Customer "+ customer.getName();
    }

    @PostMapping("/customer/{name}")
    public String putCustomer(@PathVariable("id") String customerName){
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/{name}", Customer.class, customerName);
        return "Added Customer "+ customer.getName();
    }

    @PutMapping("/customer/{id}")
    public String putCustomerById(@PathVariable("id") String customerName){
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/{id}", Customer.class, customerName);
        return "Updated Customer Surname "+ customer.getName();
    }

    @PutMapping("/customer/{name}")
    public String putCustomerByName(@PathVariable("name") String customerName){
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/{name}", Customer.class, customerName);
        return "Updated Customer ID "+ customer.getName();
    }

}
