package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
@RestController
public class CustomerEndpoint {

    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping("/customer/id/{customerId}")
    public String getCustomer(@PathVariable("customerId") Long customerId) {
        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/id/{customerId}", Customer.class, customerId);
        return "Welcome " + customer.getName();
    }

    @RequestMapping("/customer/name/{customerName}")
    public String getCustomer(@PathVariable("customerName") String customerName) {

        Customer customer =
                this.restTemplate.getForObject("http://localhost:8000/customer/name/{customerName}", Customer.class, customerName);
        return "Welcome " + customer.getName();
    }


    @RequestMapping(value = "/customer/name", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomerByName( @RequestBody Customer customer) throws Exception{
        JSONObject addNewCustomer = new JSONObject();
        addNewCustomer.put("id",4L);
        addNewCustomer.put("name", "William");
        addNewCustomer.put("surname", "Diaz");

        ResponseEntity<Customer> Response = this.restTemplate.exchange(
                RequestEntity.post(URI.create("http://localhost:8000/customer/id"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(addNewCustomer.toString()), Customer.class);

        return Response.getBody().getName();
    }

    @PostMapping(value = "/customer/id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomerById(@RequestBody Customer customer) throws Exception{
        JSONObject addNewCustomer = new JSONObject();
        addNewCustomer.put("id",5L);
        addNewCustomer.put("name", "Thomas");
        addNewCustomer.put("surname", "Pelaez");

        ResponseEntity<Customer> Response = this.restTemplate.exchange(
                RequestEntity.post(URI.create("http://localhost:8000/customer/name"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(addNewCustomer.toString()), Customer.class);
        return Response.getBody().getName();
    }

    @PutMapping(value = "/customer/id/{customerId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String updateCustomerById(@PathVariable("customerId") Long customerId, @RequestBody Customer customer){
        JSONObject updateCustomer = new JSONObject();
        updateCustomer.put("id",1L);
        updateCustomer.put("name", "Mike");
        updateCustomer.put("surname", "Castro");

        this.restTemplate.exchange(
                RequestEntity.put(URI.create("http://localhost:8000/customer/1"))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(updateCustomer.toString()), Customer.class);

        // Validate the updated User
        this.restTemplate = new RestTemplate();
        Customer testCustomer =
                this.restTemplate.getForObject("http://localhost:8000/customer/id/1", Customer.class, customerId);
        return "Welcome " + customer.getName()+ customer.getSurname();

    }



}
