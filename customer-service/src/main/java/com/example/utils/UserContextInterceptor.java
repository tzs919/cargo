package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class UserContextInterceptor implements ClientHttpRequestInterceptor {

    @Autowired
    private UserContext userContext;

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        HttpHeaders headers = request.getHeaders();
        headers.add(userContext.CORRELATION_ID, userContext.getCorrelationId());
        headers.add(userContext.AUTH_TOKEN, userContext.getAuthToken());

        System.out.println("======UserContextInterceptor========" + userContext.getCorrelationId());

        return execution.execute(request, body);
    }
}