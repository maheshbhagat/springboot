package com.example.master_api_handling.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Headers{
    public String connection;
    public String host;
    @JsonProperty("x-real-ip")
    private String xRealIp;

    @JsonProperty("x-forwarded-for")
    private String xForwardedFor;

    @JsonProperty("sec-ch-ua")
    private String secChUa;
    public String accept;
    @JsonProperty("sec-ch-ua-mobile")
    private String secChUaMobile;

    @JsonProperty("user-agent")
    private String userAgent;

    @JsonProperty("sec-ch-ua-platform")
    private String secChUaPlatform;

    @JsonProperty("sec-fetch-site")
    private String secFetchSite;

    @JsonProperty("sec-fetch-mode")
    private String secFetchMode;

    @JsonProperty("sec-fetch-dest")
    private String secFetchDest;
    public String referer;
    @JsonProperty("accept-encoding")
    private String acceptEncoding;

    @JsonProperty("accept-language")
    private String acceptLanguage;
    public String cookie;
    @JsonProperty("if-none-match")
    private String ifNoneMatch;
}