package com.example.master_api_handling.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {

    private Integer statusCode;
    private String statusMessage;
    private String description;
    private String category;
}
