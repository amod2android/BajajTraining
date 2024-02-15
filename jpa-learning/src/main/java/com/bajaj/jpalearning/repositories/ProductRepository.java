package com.bajaj.jpalearning.repositories;


import com.bajaj.jpalearning.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public String findByCode(String code);

}
