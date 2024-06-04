package com.example.master_api_handling.controller;

import com.example.master_api_handling.model.SingleStatusCode;
import com.example.master_api_handling.model.StatusCode;
import com.example.master_api_handling.service.StatusCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status-codes")
public class StatusController {

    @Autowired
    private StatusCodeService statusCodeService;

    @GetMapping("/")
    public StatusCode getAllStatusCodes(){

        System.out.println("StatusController.getAllStatusCodes");
        return statusCodeService.getAllStatusCodes();
    }

    @GetMapping("/{statusCode}")
    public SingleStatusCode getAllStatusCodes(@PathVariable String statusCode){

        System.out.println("StatusController.getAllStatusCodes");
        System.out.println("statusCode :: "+statusCode);
        return statusCodeService.getSingleStatusCode(statusCode);
    }


}
