package com.vikram.traffic.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleLocationNotFound(LocationNotFoundException ex, HttpServletRequest request) {
        return new ApiError(
                404,
                "Location not found",
                ex.getMessage(),
                request.getRequestURI()
        );
    }
}
