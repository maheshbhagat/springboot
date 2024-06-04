package com.example.master_api_handling.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("httpmethods")
@Getter
@Setter
public class HttpMethods {

    private String retrieveResource;
    private String createResource;
    private String updateResource;
    private String partiallyUpdateResource;
    private String deleteResource;
}
