package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// custom error response for registration when username already exists

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateUserException extends RuntimeException{
    
}
