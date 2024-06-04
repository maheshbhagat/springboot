package com.example.master_api_handling.service;

import com.example.master_api_handling.config.StatusCodesConfig;
import com.example.master_api_handling.model.SingleStatusCode;
import com.example.master_api_handling.model.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class StatusCodeService {

    @Autowired
    private StatusCodesConfig statusCodesConfig;
    @Autowired
    private RestTemplate restTemplate;

    public StatusCode getAllStatusCodes(){

        System.out.println("StatusCodeService.getAllStatusCodes");
        return restTemplate.getForObject(statusCodesConfig.getAllStatusCodeApi(), StatusCode.class);
    }

    public SingleStatusCode getSingleStatusCode(String statusCode){
        System.out.println("StatusCodeService.getSingleStatusCode");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(statusCodesConfig.getSpecificStatusCodeApi());

        URI uri = builder.buildAndExpand(statusCode).toUri();
        String url = uri.toString();
        return restTemplate.getForObject(url, SingleStatusCode.class);
    }
}
