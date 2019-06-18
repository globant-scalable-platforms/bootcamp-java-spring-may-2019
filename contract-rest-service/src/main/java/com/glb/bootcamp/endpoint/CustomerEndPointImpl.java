package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Api(value = "Customer Controller Implementation")
@RestController
public class CustomerEndPointImpl implements ICustomerEndPoint{

    private final CustomerService customerService;


    public CustomerEndPointImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerService.findCustomerById(id);
    }

    @Override
    public ResponseEntity<String> addCustomer(Customer customer) {

        Long id = customerService.addCustomer(customer);

        if(id>0) return new ResponseEntity<>("id: " + id, HttpStatus.CREATED);

        return new ResponseEntity<>("Can´t save customer.", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity update(Long id, Customer customer) {

        Customer updatedCustomer = customerService.updateCustomer(id, customer);

        if(Objects.nonNull(updatedCustomer))
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(updatedCustomer);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can´t find customer with id: "+ id);
    }

    @Override
    public ResponseEntity delete(Long id) {

        Customer deletedCustomer = customerService.deleteCustomer(id);

        if(Objects.nonNull(deletedCustomer)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(deletedCustomer);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can´t find customer with id: "+ id);
    }
}
