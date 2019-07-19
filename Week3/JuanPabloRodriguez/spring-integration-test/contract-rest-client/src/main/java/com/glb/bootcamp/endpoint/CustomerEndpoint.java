package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerEndpoint {

    private final RestTemplate restTemplate;

    public CustomerEndpoint(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/{customerId}")
    public String getCustomer(@PathVariable("customerId") Long customerId) {
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/{customerId}", Customer.class, customerId);
        return "Welcome " + customer.getName();
    }

    @PostMapping
    public String saveCustomer(@RequestBody @Valid Customer customer){
        ResponseEntity<Customer> response = this.restTemplate.postForEntity("http://localhost:8000/customer", customer, Customer.class);
        if(response.getStatusCode() == HttpStatus.CREATED){
            return "Customer added" + customer.getId() + customer.getName();
        }

        else {
            return "Error";
        }
    }


}
