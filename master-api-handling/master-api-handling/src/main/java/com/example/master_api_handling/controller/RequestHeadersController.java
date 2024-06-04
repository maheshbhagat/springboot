package com.example.master_api_handling.controller;

import com.example.master_api_handling.model.headersinfo.RequestHeadersResponse;
import com.example.master_api_handling.service.RequestHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class RequestHeadersController {

    @Autowired
    private RequestHeaderService requestHeaderService;

    @GetMapping("/header-info")
    public RequestHeadersResponse getHeaderInfo(){

        System.out.println("RequestHeadersController.getHeaderInfo");

        return requestHeaderService.requestHeaders();
    }

    @GetMapping("/header-ip")
    public RequestHeadersResponse getClientIp(){

        System.out.println("RequestHeadersController.getClientIp");

        return requestHeaderService.requestClientIPAddress();
    }

    @GetMapping("/user-agent")
    public RequestHeadersResponse getUserAgent(){

        System.out.println("RequestHeadersController.getUserAgent");

        return requestHeaderService.requestUserAgent();
    }

    @GetMapping("/path-variable/{pathVariable}")
    public RequestHeadersResponse getPathVariable(@PathVariable Integer pathVariable){

        System.out.println("RequestHeadersController.getPathVariable");
        return this.requestHeaderService.requestPathVariables(pathVariable);
    }

    @GetMapping("/query-parameter")
    public RequestHeadersResponse getQueryParameters(@RequestParam String query1, @RequestParam String query2, @RequestParam String query3) {

        System.out.println("query1 ::" + query1);
        System.out.println("query2 ::" + query2);
        System.out.println("query3 ::" + query3);
        System.out.println("RequestHeadersController.getQueryParameters");
        return this.requestHeaderService.requestQueryParams(query1, query2, query3);
    }
}
