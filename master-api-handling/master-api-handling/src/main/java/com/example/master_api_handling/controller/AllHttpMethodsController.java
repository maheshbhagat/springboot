package com.example.master_api_handling.controller;

import com.example.master_api_handling.model.Root;
import com.example.master_api_handling.service.RestApiConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/http-methods")
public class AllHttpMethodsController {

    @Autowired
    RestApiConsumerService restApiConsumerService;

    @GetMapping("/")
    public Root retrieveResource(){

        System.out.println("AllHttpMethodsController.consumeGetApi");
        return restApiConsumerService.retrieveResource();
    }

    @PostMapping("/")
    public Root createResource(){

        System.out.println("AllHttpMethodsController.consumePostApi");
        return restApiConsumerService.createResource();
    }

    @PutMapping("/")
    public Root updateResource(){

        System.out.println("AllHttpMethodsController.updateResource");
        return restApiConsumerService.updateResource();
    }

    @PatchMapping("/")
    public Root partiallyUpdateResource(){

        System.out.println("AllHttpMethodsController.partiallyUpdateResource");
        return restApiConsumerService.partiallyUpdateResource();
    }

    @DeleteMapping("/")
    public Root deleteResource(){

        System.out.println("AllHttpMethodsController.deleteResource");
        return restApiConsumerService.deleteResource();
    }

}
