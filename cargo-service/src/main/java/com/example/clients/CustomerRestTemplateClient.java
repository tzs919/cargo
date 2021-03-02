package com.example.clients;

import com.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class CustomerRestTemplateClient {
    @Autowired
    RestTemplate restTemplate;

    public Customer getCustomer(Long customerId) {
        ResponseEntity<Customer> restExchange =
                restTemplate.exchange(
                        "http://zuulservice/api/customer/v1/customers/{customerId}",
                        HttpMethod.GET,
                        null, Customer.class, customerId);

        return restExchange.getBody();
    }
}
