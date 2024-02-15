package com.bajaj.jpalearning.services;

import com.bajaj.jpalearning.exceptios.EntityAlreadyExistException;
import com.bajaj.jpalearning.exceptios.EntityNotFoundException;
import com.bajaj.jpalearning.models.Product;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new EntityNotFoundException("Product is not present");
    }

    public Object create(Product product) {
        if (productRepository.findByCode(product.getCode()).isEmpty()) {
            return productRepository.save(product);
        }
        throw new EntityAlreadyExistException("Product is not present");
    }
}



