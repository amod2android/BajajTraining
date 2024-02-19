package com.bajaj.jpalearning.services;

import com.bajaj.jpalearning.exceptios.EntityNotFoundException;
import com.bajaj.jpalearning.models.CartItem;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.models.Product;
import com.bajaj.jpalearning.repositories.CartRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;




    public CartItem create(CartItem cartItem) {
        Optional<Product> productOptional = productRepository.findById(cartItem.getProduct().getId());
        Optional<Customer> customerOptional = customerRepository.findById(cartItem.getCustomer().getId());
        if (productOptional.isPresent() && customerOptional.isPresent() && cartItem.getQuantity() > 0) {
            return cartRepository.save(cartItem);
        }
        throw new EntityNotFoundException("Product or Customer with this Id does not Exists");
    }

    public List<Product> getCustomerCartItems(Long customerId){
        Optional<Customer> customerOptional=customerRepository.findById(customerId);
        if (customerOptional.isPresent()){
            List<CartItem> cartItems=cartRepository.findByCustomer(customerOptional.get());
            if (!cartItems.isEmpty()){
                return cartItems.stream().map((cartItem -> cartItem.getProduct())).toList();
            }
        }
        throw new EntityNotFoundException("Cart not found");
    }
}
