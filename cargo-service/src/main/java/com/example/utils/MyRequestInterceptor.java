package com.example.utils;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRequestInterceptor implements RequestInterceptor {

    @Autowired
    private UserContext userContext;

    @Override
    public void apply(RequestTemplate requestTemplate) {

        Request request = requestTemplate.request();
        String url = request.url();
        System.out.println("=======MyRequestInterceptor===========" + url);//     /api/customer/v1/customers/3


        requestTemplate.header(UserContext.CORRELATION_ID, userContext.getCorrelationId());
        requestTemplate.header(UserContext.AUTH_TOKEN, userContext.getAuthToken());
    }
}
