package com.bajaj.jpalearning.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String imageUrl;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "product")
    private List<CartItem> carts;

    @CreationTimestamp()
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    public Product() {
    }

    public Product(String name, Double price, String imageUrl, String code) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.code = code;
    }

    public Product(String name, Double price, String imageUrl, String code, List<CartItem> carts) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.code = code;
        this.carts = carts;
    }

    public Product(Long id, String name, Double price, String imageUrl, String code, List<CartItem> carts, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.code = code;
        this.carts = carts;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CartItem> getCarts() {
        return carts;
    }

    public void setCarts(List<CartItem> carts) {
        this.carts = carts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
