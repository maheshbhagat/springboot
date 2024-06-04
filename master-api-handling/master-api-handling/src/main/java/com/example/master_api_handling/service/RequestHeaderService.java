package com.example.master_api_handling.service;

import com.example.master_api_handling.config.HeadersConfig;
import com.example.master_api_handling.model.headersinfo.RequestHeadersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RequestHeaderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HeadersConfig headersConfig;

    public RequestHeadersResponse requestHeaders(){

        System.out.println("RequestHeaderService.requestHeaders");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(this.headersConfig.getHeaderInfoApi(), HttpMethod.GET, entity, RequestHeadersResponse.class);

        return response.getBody();
    }

    public RequestHeadersResponse requestClientIPAddress(){

        System.out.println("RequestHeaderService.requestClientIPAddress");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(this.headersConfig.getClientIpAddressApi(), HttpMethod.GET, entity, RequestHeadersResponse.class);

        return response.getBody();
    }

    public RequestHeadersResponse requestUserAgent(){

        System.out.println("RequestHeaderService.requestUserAgent");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(this.headersConfig.getUserAgentApi(), HttpMethod.GET, entity, RequestHeadersResponse.class);

        return response.getBody();
    }

    public RequestHeadersResponse requestPathVariables(Integer pathVariable){

        System.out.println("RequestHeaderService.requestPathVariables");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.headersConfig.getPathVariableApi());

        URI uri = builder.buildAndExpand(pathVariable).toUri();
        String url = uri.toString();

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(url, HttpMethod.GET, entity,RequestHeadersResponse.class);

        return response.getBody();
    }

    public RequestHeadersResponse requestQueryParams(String query1, String query2, String query3){

        System.out.println("RequestHeaderService.requestQueryParams");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.headersConfig.getQueryParamApi())
                .queryParam("query1", query1)
                .queryParam("query2", query2)
                .queryParam("query3", query3);

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, entity, RequestHeadersResponse.class);
        return response.getBody();
    }
}
