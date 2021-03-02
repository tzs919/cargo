package com.example.clients;

import com.example.domain.Customer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("zuulservice")
public interface CustomerFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/customer/v1/customers/{customerId}",
            consumes = "application/json")

//@RequestHeader(name="bbb",required = false)String bbb)

    Customer getCustomer(@PathVariable("customerId") Long customerId);
}
