package com.bajaj.jpalearning.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // mandatory
    private int id;

    @Column(name = "name") // optional
    private String name;
    private int age;
    private String emailId;

}
