package com.bajaj.jpalearning.controllers;

import com.bajaj.jpalearning.beens.ResponseHandler;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseHandler.createResponse("Found Customer", HttpStatus.OK, customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Customer customer = customerService.get(id);
        return ResponseHandler.createResponse("Found", HttpStatus.OK, customerService.get(id));
    }


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Customer customer) {
        Customer createCustomer = customerService.create(customer);
        return ResponseHandler.createResponse("Created", HttpStatus.CREATED, createCustomer);
    }
}
