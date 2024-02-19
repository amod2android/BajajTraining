package com.bajaj.jpalearning.controllers;

import com.bajaj.jpalearning.beens.ResponseHandler;
import com.bajaj.jpalearning.models.CartItem;
import com.bajaj.jpalearning.models.Product;
import com.bajaj.jpalearning.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerCartItems(@PathVariable Long id){
        List<Product> products=cartService.getCustomerCartItems(id);
        return ResponseHandler.createResponse("Found", HttpStatus.OK,products);
    }

    @PostMapping("/addtocart")
    public CartItem create(@RequestBody CartItem cartItem){
        return cartService.create(cartItem);

    }
}
