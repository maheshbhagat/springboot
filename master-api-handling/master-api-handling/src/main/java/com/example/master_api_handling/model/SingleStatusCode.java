package com.example.master_api_handling.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class SingleStatusCode {

    private Integer statusCode;
    private Status data;
    private String message;
    private Boolean success;
}
