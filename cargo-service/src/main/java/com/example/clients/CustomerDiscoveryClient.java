package com.example.clients;

import com.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@Component
public class CustomerDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public Customer getCustomer(Long customerId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("customerservice");

        if (instances.size() == 0) return null;
        String serviceUri = String.format("%s/v1/customers/%d", instances.get(0).getUri().toString(), customerId);
        System.out.println("!!!! SERVICE URI:  " + serviceUri);
        // !!!! SERVICE URI:  http://172.21.0.4:8085/v1/customers/1

        ResponseEntity<Customer> restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.GET,
                        null, Customer.class, customerId);

        return restExchange.getBody();
    }
}
