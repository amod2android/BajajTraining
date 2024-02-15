package com.bajaj.jpalearning.services;

import com.bajaj.jpalearning.exceptios.EntityNotFoundException;
import com.bajaj.jpalearning.models.Address;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerService customerService;


    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public List<Address> get(Long id) {
        Customer customer = customerService.get(id);
        List<Address> addresses = addressRepository.findByCustomer(customer);
        if (!addresses.isEmpty()) {
            return addresses;
        }
        throw new EntityNotFoundException("Address not found for the customer");
    }


    public Object create(Address address) {
        Customer customer = customerService.get(address.getCustomer().getId());
        address.setCustomer(customer);
        return addressRepository.save(address);
    }
}
