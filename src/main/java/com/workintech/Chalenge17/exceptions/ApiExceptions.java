package com.workintech.Chalenge17.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiExceptions extends RuntimeException{
 private HttpStatus httpStatus;


    public ApiExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }
}
