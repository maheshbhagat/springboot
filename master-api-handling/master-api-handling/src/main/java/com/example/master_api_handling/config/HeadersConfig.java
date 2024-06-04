package com.example.master_api_handling.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("headers")
@Getter
@Setter
public class HeadersConfig {

    private String headerInfoApi;
    private String clientIpAddressApi;
    private String userAgentApi;
    private String pathVariableApi;
    private String queryParamApi;

}
