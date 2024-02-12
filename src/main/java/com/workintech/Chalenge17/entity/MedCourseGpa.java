package com.workintech.Chalenge17.entity;


import org.springframework.stereotype.Component;

@Component
public class MedCourseGpa implements  CourseGpa{
    @Override
    public int getGpa() {
        return 5;
    }
}
