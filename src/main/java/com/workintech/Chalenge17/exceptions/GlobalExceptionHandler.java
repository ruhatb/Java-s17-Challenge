package com.workintech.Chalenge17.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.details;

@Slf4j

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiEror> hadnleApiExceptions(ApiExceptions apiExceptions){
        log.error("errros", Exception details, apiExceptions.getMessage());
        ApiEror apiEror= new ApiEror()(apiExceptions.getHttpStatus.value(), apiExceptions.getMessage(), System.currentTimeMillis());
return new ResponseEntity<>(apiEror,apiExceptions.getHttpStatus());
    }

    @ExceptionHandler ResponseEntity<ApiEror> handlerAllExceptions(Exception exception){
        log.error("errros", Exception details, apiExceptions.getMessage());
        ApiEror apiEror = new ApiEror(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),System.currentTimeMillis());
    }



}
