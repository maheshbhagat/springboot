package com.example.master_api_handling.service;

import com.example.master_api_handling.config.HttpMethods;
import com.example.master_api_handling.exception.HttpMethodException;
import com.example.master_api_handling.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RestApiConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpMethods httpMethods;

    public Root retrieveResource(){

        System.out.println("RestApiConsumerService.consumeGetApi");

        return restTemplate.getForObject(httpMethods.getRetrieveResource(), Root.class);
    }

    public Root createResource(){

        System.out.println("RestApiConsumerService.consumePostApi");

        ResponseEntity<Root> response = restTemplate
                .exchange(httpMethods.getCreateResource(), HttpMethod.POST, null, Root.class);

        return response.getBody();
    }

    public Root updateResource(){

        System.out.println("RestApiConsumerService.updateResource");

        ResponseEntity<Root> response = restTemplate
                .exchange(httpMethods.getUpdateResource(), HttpMethod.PUT, null, Root.class);

        return response.getBody();
    }

    public Root partiallyUpdateResource(){

        System.out.println("RestApiConsumerService.partiallyUpdateResource");

        try {
            ResponseEntity<Root> response = restTemplate
                    .exchange(httpMethods.getPartiallyUpdateResource(), HttpMethod.PATCH, null, Root.class);
            return response.getBody();
        } catch (Exception ex){
            throw new HttpMethodException(ex.getMessage(), ex);
        }
    }

    public Root deleteResource(){

        System.out.println("RestApiConsumerService.deleteResource");

        ResponseEntity<Root> response = restTemplate
                .exchange(httpMethods.getDeleteResource(), HttpMethod.DELETE, null, Root.class);

        return response.getBody();
    }
}
