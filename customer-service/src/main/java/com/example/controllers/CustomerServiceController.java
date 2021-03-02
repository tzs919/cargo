package com.example.controllers;

import com.example.config.ServiceConfig;
import com.example.domain.Customer;
import com.example.services.CustomerService;
import com.example.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/customers")
public class CustomerServiceController {

    private int count = 0;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceConfig serviceConfig;

    @Autowired
    private UserContext userContext;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("customerId") Long customerId) {
        count++;

        System.out.println("============" + count
                + "====uri:" + discoveryClient.getLocalServiceInstance().getUri());
        System.out.println("=================CustomerServiceController Correlation id: "+ userContext.getCorrelationId());

        return customerService.getCustomer(customerId).setAddress(serviceConfig.getExampleAddress());
    }
}
