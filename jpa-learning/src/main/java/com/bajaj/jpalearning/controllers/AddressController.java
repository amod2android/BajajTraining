package com.bajaj.jpalearning.controllers;

import com.bajaj.jpalearning.beens.ResponseHandler;
import com.bajaj.jpalearning.models.Address;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseHandler.createResponse("Found Address", HttpStatus.OK, addressService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseHandler.createResponse("Found", HttpStatus.OK, addressService.get(id));
    }


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Address address) {
        Object createAddress = addressService.create(address);
        if (createAddress != null) {
            return ResponseHandler.createResponse("Address Added", HttpStatus.CREATED, addressService.create(address));
        }
        return ResponseHandler.createResponse("Address Already Exist", HttpStatus.CONFLICT, null);

    }
}
