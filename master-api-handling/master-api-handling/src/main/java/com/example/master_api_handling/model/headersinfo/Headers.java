package com.example.master_api_handling.model.headersinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers{

    @JsonProperty("connection")
    public String connection;
    @JsonProperty("host")
    public String host;
    @JsonProperty("x-real-ip")
    public String xRealIp;
    @JsonProperty("x-forwarded-for")
    public String xForwardedFor;
    @JsonProperty("sec-ch-ua")
    public String secChUa;
    @JsonProperty("accept")
    public String accept;
    @JsonProperty("sec-ch-ua-mobile")
    public String secChUaMobile;
    @JsonProperty("user-agent")
    public String userAgent;
    @JsonProperty("sec-ch-ua-platform")
    public String secChUaPlatform;
    @JsonProperty("sec-fetch-site")
    public String secFetchSite;
    @JsonProperty("sec-fetch-mode")
    public String secFetchMode;
    @JsonProperty("sec-fetch-dest")
    public String secFetchDest;
    @JsonProperty("referer")
    public String referer;
    @JsonProperty("cache-control")
    public String cacheControl;
    @JsonProperty("postman-token")
    public String postmanToken;
    @JsonProperty("accept-encoding")
    public String acceptEncoding;
    @JsonProperty("accept-language")
    public String acceptLanguage;
    @JsonProperty("cookie")
    public String cookie;
}