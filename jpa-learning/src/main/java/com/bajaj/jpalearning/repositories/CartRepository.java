package com.bajaj.jpalearning.repositories;

import com.bajaj.jpalearning.models.CartItem;
import com.bajaj.jpalearning.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem,Long> {
    public List<CartItem> findByCustomer(Customer customer);
}
