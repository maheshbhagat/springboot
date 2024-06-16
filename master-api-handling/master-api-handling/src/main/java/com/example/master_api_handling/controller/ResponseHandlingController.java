package com.example.master_api_handling.controller;

import com.example.master_api_handling.model.headersinfo.RequestHeadersResponse;
import com.example.master_api_handling.service.FetchResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/response")
public class ResponseHandlingController {

    @Autowired
    private FetchResponseService fetchResponseService;

    @GetMapping("/get-headers")
    public RequestHeadersResponse getHeaders(){

        System.out.println("ResponseHandlingController.getHeaders");
        return fetchResponseService.getResponseHeaders();
    }

    @GetMapping("/set-cache/{timeToLive}/{cacheResponseDirective}")
    public RequestHeadersResponse setCache(@PathVariable Integer timeToLive, @PathVariable String cacheResponseDirective){

        System.out.println("ResponseHandlingController.setCache");
        return fetchResponseService.setCaching(timeToLive, cacheResponseDirective);
    }

    @GetMapping("/get-html")
    public String getHtmlResponse(){

        System.out.println("ResponseHandlingController.getHtmlResponse");
        return fetchResponseService.getHtmlResponse();
    }

    @GetMapping("/get-xml")
    public String getXmlResponse(){

        System.out.println("ResponseHandlingController.getXmlResponse");
        return fetchResponseService.getXmlResponse();
    }

    @GetMapping("/get-gzip")
    public RequestHeadersResponse getGzipResponse(){

        System.out.println("ResponseHandlingController.getGzipResponse");
        return fetchResponseService.getGzipResponse();
    }

    @GetMapping("/get-brotli")
    public RequestHeadersResponse getBrotliResponse(){

        System.out.println("ResponseHandlingController.getBrotliResponse");
        return fetchResponseService.getBrotliResponse();
    }

    @GetMapping("/get-cookies")
    public RequestHeadersResponse getCookies(){

        System.out.println("ResponseHandlingController.getCookies");
        return fetchResponseService.getCookies();
    }

    @PostMapping("/set-cookies")
    public RequestHeadersResponse setCookies(){

        System.out.println("ResponseHandlingController.setCookies");
        return fetchResponseService.setCookies();
    }

    @DeleteMapping("/remove-cookies")
    public RequestHeadersResponse removeCookies(@RequestParam String cookieKey){

        System.out.println("ResponseHandlingController.removeCookies");
        return fetchResponseService.removeCookies(cookieKey);
    }

    @GetMapping("/redirect-url")
    public String redirectUrl(@RequestHeader String accept ,@RequestParam String url){

        System.out.println("ResponseHandlingController.redirectUrl");
        System.out.println("ResponseHandlingController.redirectUrl :: "+accept);
        return fetchResponseService.redirectToUrl(accept, url);
    }

    @GetMapping("/get-jpeg")
    public byte[] jpegDownload(){

        System.out.println("ResponseHandlingController.jpegDownload");
        return fetchResponseService.jpegDownload();
    }

    @GetMapping("/get-jpg")
    public byte[] jpgDownload(){

        System.out.println("ResponseHandlingController.jpgDownload");
        return fetchResponseService.jpgDownload();
    }

    @GetMapping("/get-png")
    public byte[] pngDownload(){

        System.out.println("ResponseHandlingController.pngDownload");
        return fetchResponseService.pngDownload();
    }

    @GetMapping("/get-webp")
    public byte[] webpDownload(){

        System.out.println("ResponseHandlingController.webpDownload");
        return fetchResponseService.webpDownload();
    }

    @GetMapping("/get-svg")
    public String svgDownload(){

        System.out.println("ResponseHandlingController.svgDownload");
        return fetchResponseService.svgDownload();
    }

}
