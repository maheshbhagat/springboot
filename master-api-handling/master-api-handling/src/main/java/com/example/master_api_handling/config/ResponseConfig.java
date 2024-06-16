package com.example.master_api_handling.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("response")
@Getter
@Setter
public class ResponseConfig {

    private String headersApi;
    private String cachingApi;
    private String htmlCompressionApi;
    private String xmlCompressionApi;
    private String gzipCompressionApi;
    private String brotliCompressionApi;
    private String getCookiesApi;
    private String setCookiesApi;
    private String removeCookiesApi;
    private String redirectUrlApi;
    private String jpegDownloadApi;
    private String jpgDownloadApi;
    private String pngDownloadApi;
    private String webpDownloadApi;
    private String svgDownloadApi;
}
