package com.example.services;

import com.example.config.ServiceConfig;
import com.example.db.CustomerRepository;
import com.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ServiceConfig config;

    public Customer getCustomer(Long customerId) {
        Customer customer = customerRepository.findOne(customerId);
        return customer;
    }
}
