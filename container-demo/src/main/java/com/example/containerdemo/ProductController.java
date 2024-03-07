package com.example.containerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping("")
    public Product create(@RequestBody Product product) {
     return productRepository.save(product);

    }
}
