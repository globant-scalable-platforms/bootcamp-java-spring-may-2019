package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class CustomerEndpoint {

    private final RestTemplate restTemplate;

    public CustomerEndpoint(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @PostMapping("/customers")
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        return restTemplate.postForEntity("http://localhost:8000/customers", customer, ResponseEntity.class);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
        return restTemplate.getForEntity("http://localhost:8000/customers/" + id, Customer.class);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        return restTemplate.exchange(RequestEntity.put(URI.create("http://localhost:8000/customers/" + id))
                                                  .contentType(MediaType.APPLICATION_JSON)
                                                  .body(customer), ResponseEntity.class);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Long id) {
        return restTemplate.exchange(RequestEntity.delete(URI.create("http://localhost:8000/customers/" + id)).build(),
                                                  ResponseEntity.class);
    }
}
