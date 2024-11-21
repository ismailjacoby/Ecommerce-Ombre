package com.ismailjacoby.ecommercebackend.pl.controllers;

import com.ismailjacoby.ecommercebackend.bll.exceptions.EmailAlreadySubscribedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle EmailAlreadySubscribedException
    @ExceptionHandler(EmailAlreadySubscribedException.class)
    public ResponseEntity<String> handleEmailAlreadySubscribed(EmailAlreadySubscribedException ex) {
        // Return a Bad Request (400) response with the exception message
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    // Handle validation errors (e.g., @NotBlank, @Email)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Collect all validation errors
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        // Return 400 Bad Request with validation error details
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
