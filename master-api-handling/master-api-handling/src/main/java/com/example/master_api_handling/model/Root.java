package com.example.master_api_handling.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Root{
    public int statusCode;
    public Data data;
    public String message;
    public boolean success;
}
