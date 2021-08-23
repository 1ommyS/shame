package com.shop.shopapi.controller;

import com.shop.shopapi.entity.Customer;
import com.shop.shopapi.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return service.findCustomerById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        service.createCustomer(customer);
    }


    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        try {
            service.updateCustomer(customer, id);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Customer is updated",HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        try {
            service.deleteCustomerById(id);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }
}
