package com.example.master_api_handling.model.headersinfo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    public Headers headers;
    public String ip;
    public String ipv;
    public String userAgent;
    public String pathVariable;
    public String query1;
    public String query2;
    public String query3;

    public String contentEncoding;
    public String string;

    public Cookies cookies;
}
