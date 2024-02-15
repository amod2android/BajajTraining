package com.bajaj.jpalearning.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

import static com.bajaj.jpalearning.Constants.CUSTOMERS;

@Entity
@Table(name = CUSTOMERS)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mandatory
    private Long id;

    @Column(name = "name", length = 50, nullable = false) // optional
    private String name;
    private int age;

    @Column(unique = true, length = 100)
    private String emailId;

    @JsonIgnore
    private String password;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Address> addresses;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> carts;

    @CreationTimestamp()
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    public Customer() {
    }

    public Customer(String name, int age, String emailId, String password) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.password = password;
    }

    public Customer(String name, int age, String emailId, String password, List<Address> addresses, List<CartItem> carts) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.password = password;
        this.addresses = addresses;
        this.carts = carts;
    }

    public Customer(Long id, String name, int age, String emailId, String password, List<Address> addresses, List<CartItem> carts, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.password = password;
        this.addresses = addresses;
        this.carts = carts;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<CartItem> getCarts() {
        return carts;
    }

    public void setCarts(List<CartItem> carts) {
        this.carts = carts;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
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
