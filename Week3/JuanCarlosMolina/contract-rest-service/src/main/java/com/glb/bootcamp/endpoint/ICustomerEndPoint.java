package com.glb.bootcamp.endpoint;

import com.glb.bootcamp.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "CustomerController")
public interface ICustomerEndPoint {


    @ApiOperation(value = "Get a list of Customer", response = Iterable.class, tags = "IgetCustomers")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Success|OK"))
    @GetMapping("/icostumers")
    public List<Customer> findAll();

    @ApiOperation(value = "Get a customer by id", response = Customer.class, tags = "IfindCustomerById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not found!!!") })
    @GetMapping("/icustomer/{id}")
    public Customer findCustomerById(@PathVariable("id") Long id);

    @ApiOperation(value = "Add a new customer", response = Customer.class, tags = "IaddCustomer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping("/icustomers/")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer);

    @ApiOperation(value = "Updates an existing customer", response = Customer.class, tags = "IupdateCustomer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @PutMapping("/icustomers/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Customer customer);

    @ApiOperation(value = "Deletes an existing customer", response = Customer.class, tags = "IdeleteCustomer")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @DeleteMapping("/icustomers/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id);
}
