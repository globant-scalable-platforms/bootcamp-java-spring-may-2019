package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerEndpoint {

    private final RestTemplate restTemplate;

    public CustomerEndpoint(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/{customerId}")
    public String getCustomer(@PathVariable("customerId") Long customerId) {
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customers/{customerId}", Customer.class, customerId);
        return "Welcome " + customer.getName();
    }

    @PostMapping
    public String createCostumer(@RequestBody @Valid Customer customer) {
        Customer newCustomer =
                this.restTemplate.postForObject("http://localhost:8000/customers", customer, Customer.class);
        return "The costumer " + newCustomer + " was created";
    }

}
