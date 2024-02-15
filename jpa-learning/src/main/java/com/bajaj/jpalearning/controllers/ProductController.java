package com.bajaj.jpalearning.controllers;

import com.bajaj.jpalearning.beens.ResponseHandler;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.models.Product;
import com.bajaj.jpalearning.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseHandler.createResponse("Found Customer", HttpStatus.OK, productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseHandler.createResponse("Found", HttpStatus.OK, productService.get(id));
    }


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Product product) {
        Object createProduct = productService.create(product);
        if (createProduct != null) {
            return ResponseHandler.createResponse("Created", HttpStatus.CREATED, createProduct);
        }
        return ResponseHandler.createResponse("Customer Already Exist", HttpStatus.CONFLICT, null);

    }
}
