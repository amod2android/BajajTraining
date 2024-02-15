package com.bajaj.jpalearning.services;

import com.bajaj.jpalearning.exceptios.EntityAlreadyExistException;
import com.bajaj.jpalearning.exceptios.EntityNotFoundException;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // fetch all customers
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    // fetch customer by id
    public Customer get(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new EntityNotFoundException("Customer with Login ID is not present");
    }

    //To create a new customer
    public Customer create(Customer customer) {
        if (customerRepository.findByEmailId(customer.getEmailId()).isEmpty()) {
            return customerRepository.save(customer);
        }
        throw new EntityAlreadyExistException("Customer with Login email ID is already exists");
    }
}
