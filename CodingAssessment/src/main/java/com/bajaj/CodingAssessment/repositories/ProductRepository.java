package com.bajaj.CodingAssessment.repositories;

import com.bajaj.CodingAssessment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
