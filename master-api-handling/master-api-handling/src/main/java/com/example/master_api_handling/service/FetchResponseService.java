package com.example.master_api_handling.service;

import com.example.master_api_handling.config.ResponseConfig;
import com.example.master_api_handling.model.headersinfo.RequestHeadersResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class FetchResponseService {

    @Autowired
    private ResponseConfig responseConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public RequestHeadersResponse getResponseHeaders(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(this.responseConfig.getHeadersApi(), HttpMethod.GET, entity, RequestHeadersResponse.class);

        return response.getBody();
    }

    public RequestHeadersResponse setCaching(Integer timeToLive, String cacheResponseDirective){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        Map<String, Object> map = new HashMap<>();
        map.put("timeToLive", timeToLive);
        map.put("cacheResponseDirective", cacheResponseDirective);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(this.responseConfig.getCachingApi());

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(uriComponentsBuilder.buildAndExpand(map).toUri().toString(), HttpMethod.GET, entity, RequestHeadersResponse.class);

        return response.getBody();

    }

    public String getHtmlResponse(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<String> response = this.restTemplate.exchange(this.responseConfig.getHtmlCompressionApi(), HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getXmlResponse(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<String> response = this.restTemplate.exchange(this.responseConfig.getXmlCompressionApi(), HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public RequestHeadersResponse getGzipResponse(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(this.responseConfig.getGzipCompressionApi(), HttpMethod.GET, entity, RequestHeadersResponse.class);

        return response.getBody();
    }

    public RequestHeadersResponse getBrotliResponse(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(this.responseConfig.getBrotliCompressionApi(), HttpMethod.GET, entity, RequestHeadersResponse.class);

        return response.getBody();
    }

    public RequestHeadersResponse getCookies(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(this.responseConfig.getGetCookiesApi(), HttpMethod.GET, entity, RequestHeadersResponse.class);

        return response.getBody();

    }

    public RequestHeadersResponse setCookies(){

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> jsonBody = new HashMap<>();
            jsonBody.put("foo", "bar");

            HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(jsonBody), headers);

            ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(this.responseConfig.getSetCookiesApi(), HttpMethod.POST, entity, RequestHeadersResponse.class);

            return response.getBody();
        }catch (JsonProcessingException ex){
            System.out.println("Error occurred while setting cookies: "+ex.getMessage());
        }
        return null;
    }

    public RequestHeadersResponse removeCookies(String cookieKey){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(this.responseConfig.getRemoveCookiesApi())
                .queryParam("cookieKey", "cookieKey");

        ResponseEntity<RequestHeadersResponse> response = this.restTemplate.exchange(uriComponentsBuilder.buildAndExpand().toUri(), HttpMethod.DELETE, entity, RequestHeadersResponse.class);

        return response.getBody();
    }

    public String redirectToUrl(String acceptHeader, String url){

        MediaType mediaType = MediaType.parseMediaType(acceptHeader);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(this.responseConfig.getRedirectUrlApi())
                .queryParam("url", url);

        ResponseEntity<String> response = this.restTemplate.exchange(uriComponentsBuilder.buildAndExpand().toUri(), HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public byte[] jpegDownload(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<byte[]> response = this.restTemplate.exchange(this.responseConfig.getJpegDownloadApi(), HttpMethod.GET, entity, byte[].class);

        return response.getBody();
    }

    public byte[] jpgDownload(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<byte[]> response = this.restTemplate.exchange(this.responseConfig.getJpgDownloadApi(), HttpMethod.GET, entity, byte[].class);

        return response.getBody();
    }

    public byte[] pngDownload(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<byte[]> response = this.restTemplate.exchange(this.responseConfig.getPngDownloadApi(), HttpMethod.GET, entity, byte[].class);

        return response.getBody();
    }

    public byte[] webpDownload(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<byte[]> response = this.restTemplate.exchange(this.responseConfig.getWebpDownloadApi(), HttpMethod.GET, entity, byte[].class);

        return response.getBody();
    }

    public String svgDownload(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<String> response = this.restTemplate.exchange(this.responseConfig.getSvgDownloadApi(), HttpMethod.GET, entity, String.class);

        return response.getBody();
    }


}
