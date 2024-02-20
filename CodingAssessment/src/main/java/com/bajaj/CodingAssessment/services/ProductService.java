package com.bajaj.CodingAssessment.services;

import com.bajaj.CodingAssessment.exceptions.EntityNotFoundException;
import com.bajaj.CodingAssessment.models.Product;
import com.bajaj.CodingAssessment.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Service
@RequestMapping("api/v1/product")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAll(){{
            return productRepository.findAll();
        }
    }

    public Product get(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }


    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        }
        throw new EntityNotFoundException("Product with id " + id + " not found");
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
