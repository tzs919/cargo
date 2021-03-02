package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ServiceConfig {

    @Value("${example.address}")
    private String exampleAddress;

    public String getExampleAddress() {
        return exampleAddress;
    }
}
