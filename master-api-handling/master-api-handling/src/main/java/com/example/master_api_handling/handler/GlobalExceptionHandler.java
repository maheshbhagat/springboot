package com.example.master_api_handling.handler;

import com.example.master_api_handling.exception.HttpMethodException;
import com.example.master_api_handling.model.HttpMethodExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<HttpMethodExceptionResponse> handleHttpMethodException(HttpMethodException exception){

        HttpMethodExceptionResponse response = new HttpMethodExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<HttpMethodExceptionResponse> handleException(Exception exception){

        HttpMethodExceptionResponse response = new HttpMethodExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
