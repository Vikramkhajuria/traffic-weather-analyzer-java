package com.vikram.traffic.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleLocationNotFound(LocationNotFoundException ex) {
        return Map.of(
                "time", Instant.now().toString(),
                "status", 404,
                "error", "Location Not Found",
                "message", ex.getMessage()
        );
    }
}
