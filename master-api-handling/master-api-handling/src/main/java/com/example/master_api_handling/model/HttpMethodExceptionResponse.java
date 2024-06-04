package com.example.master_api_handling.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HttpMethodExceptionResponse {

    private Integer status;
    private String message;
    private Long timestamp;

}
