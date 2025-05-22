package com.kaviarasu.bootstrapped_backend.Q49.controllers;

import com.kaviarasu.bootstrapped_backend.Q49.exceptions.BadCredentialsException;
import com.kaviarasu.bootstrapped_backend.Q49.exceptions.UserNotSignedUpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({BadCredentialsException.class, UserNotSignedUpException.class})
    public ResponseEntity<String> handleBadRequests(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

