package com.example.master_api_handling.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("statuscodes")
@Getter
@Setter
public class StatusCodesConfig {

    private String allStatusCodeApi;
    private String specificStatusCodeApi;
}
