package com.bajaj.jpalearning.services;

import com.bajaj.jpalearning.exceptios.EntityNotFoundException;
import com.bajaj.jpalearning.models.CartItem;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerService customerService;


    public List<CartItem> getAll() {
        return cartRepository.findAll();
    }

    public List<CartItem> get(Long id) {
        Customer customer = customerService.get(id);
        List<CartItem> cartItems = cartRepository.findByCustomer(customer);
        if (!cartItems.isEmpty()) {
            return cartItems;
        }
        throw new EntityNotFoundException("CartItem not found for the customer");
    }


    public Object create(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }
}
