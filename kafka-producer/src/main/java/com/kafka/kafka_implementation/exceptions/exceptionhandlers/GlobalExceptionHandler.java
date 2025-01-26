package com.kafka.kafka_implementation.exceptions.exceptionhandlers;

import com.kafka.kafka_implementation.exceptions.vo.exceptions.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralException> ExceptionHandler(Exception exception) {
        GeneralException e = new GeneralException("404", "Something went wrong", "Internal server error");
        return ResponseEntity.internalServerError().body(e);
    }
}
