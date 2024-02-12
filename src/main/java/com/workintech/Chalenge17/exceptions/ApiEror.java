package com.workintech.Chalenge17.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiEror {
    private Integer status;
    private String message;
    private Long timestamps;


    public ApiEror(int value, String message, long l) {

    }
}
