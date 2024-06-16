package com.example.master_api_handling.model.headersinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @JsonProperty("x-powered-by")
    public String xPoweredBy;

    @JsonProperty("access-control-allow-origin")
    public String accessControlAllowOrigin;

    @JsonProperty("access-control-allow-credentials")
    public String accessControlAllowCredentials;

    @JsonProperty("ratelimit-limit")
    public String ratelimitLimit;

    @JsonProperty("ratelimit-remaining")
    public String ratelimitRemaining;

    @JsonProperty("ratelimit-reset")
    public String ratelimitReset;

    @JsonProperty("content-type")
    public String contentType;

    @JsonProperty("content-length")
    public String contentLength;

    @JsonProperty("etag")
    public String etag;

    @JsonProperty("if-none-match")
    public String ifNoneMatch;
}