package com.workintech.Chalenge17.validations;

import com.workintech.Chalenge17.entity.Course;
import com.workintech.Chalenge17.exceptions.ApiExceptions;
import org.springframework.http.HttpStatus;

public class CourseValidation {
    public static void checkName(String name){
        if(name == null || name.isEmpty()){
            throw new ApiExceptions("Name have an error", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkCredit(Integer credit) {
        if(credit == null || credit < 0 || credit > 4){
            throw new ApiExceptions("no credit coditions", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkId(Integer id) {
        if(id == null || id < 0){
            throw new ApiExceptions("id cannot be null or less than zero", HttpStatus.BAD_REQUEST);
        }
    }
}
