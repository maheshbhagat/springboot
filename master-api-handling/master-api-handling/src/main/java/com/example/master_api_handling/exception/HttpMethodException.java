package com.example.master_api_handling.exception;

public class HttpMethodException extends RuntimeException {

    public HttpMethodException(String message, Throwable cause) {
        super(message, cause);
    }
}
