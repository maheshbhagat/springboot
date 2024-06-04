package com.example.master_api_handling.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data{
    public String method;
    public Headers headers;
    public String origin;
    public String url;
}