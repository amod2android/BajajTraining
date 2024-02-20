package com.bajaj.CodingAssessment.controllers;

import com.bajaj.CodingAssessment.beens.ResponseHandler;
import com.bajaj.CodingAssessment.models.Product;
import com.bajaj.CodingAssessment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseHandler.createResponse("Found Product", HttpStatus.OK, productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Product product = productService.get(id);
        return ResponseHandler.createResponse("Found", HttpStatus.OK, productService.get(id));
    }


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Product customer) {
        Product createProduct = productService.create(customer);
        return ResponseHandler.createResponse("Created", HttpStatus.CREATED, createProduct);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseHandler.createResponse("Product Updated", HttpStatus.OK, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseHandler.deleteResponse("Product Deleted", HttpStatus.OK);
    }

}
