package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.endpoint.model.CustomerRequest;
import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerEndpoint {

    private final CustomerService customerService;

    public CustomerEndpoint(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable("id") Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody @Valid CustomerRequest body) {
        return customerService.createCustomer(body.getName(), body.getSurname());
    }
}
