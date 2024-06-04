package com.example.master_api_handling.model;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
@Getter
@Setter
public class StatusCode {

    private Integer statusCode;
    private HashMap<String, Status> data;
    private String message;
    private Boolean success;
}
