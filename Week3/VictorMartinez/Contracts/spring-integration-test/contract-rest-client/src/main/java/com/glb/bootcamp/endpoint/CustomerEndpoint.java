package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

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

    @RequestMapping(value="/customer/id",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomer() throws InterruptedException {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Customer addNewCustomer = new Customer(4L, "Felipe", "Martinez");
        HttpEntity<Customer> entity = new HttpEntity<Customer>(addNewCustomer,headers);

        Customer customer=  this.restTemplate.postForObject("http://localhost:8000/customer/id", entity, Customer.class);

        return "Welcome new Added User " + customer.getName() + customer.getSurname();


    }

    @RequestMapping(value="/customer/id/{userId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateCustomer(@PathVariable("userId") Long userId, @RequestBody Customer oldCustomer) throws InterruptedException {

        // Create Query with new User.
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Customer> entity = new HttpEntity<Customer>(oldCustomer,headers);

        this.restTemplate.put("http://localhost:8000/customer/id/"+userId,entity);
        Customer newCustomer =
                this.restTemplate.getForObject("http://localhost:8000/customer/id/"+userId, Customer.class);

        return ("Welcome old but Updated User " + newCustomer.getId()+ " "+newCustomer.getName() +" "+ newCustomer.getSurname());


    }



}
