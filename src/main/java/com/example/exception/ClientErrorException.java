package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// custom exception to throw client errors
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientErrorException extends RuntimeException{
    
}
