package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerEndpoint {

    private final RestTemplate restTemplate;

    public CustomerEndpoint(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping(value = "/customer/id/{customerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCustomer(@PathVariable("customerId") Long customerId) {
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/id/{customerId}", Customer.class, customerId);
        return "Welcome " + customer.getName();
    }

    @RequestMapping(value="/customer/name/{customerName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCustomer(@PathVariable("customerName") String customerName) {
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/name/{customerName}", Customer.class, customerName);
        return "Welcome " + customer.getName();
    }

}
