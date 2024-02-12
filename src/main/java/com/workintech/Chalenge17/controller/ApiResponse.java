package com.workintech.Chalenge17.controller;

import com.workintech.Chalenge17.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ApiResponse {
    private Course course;
    private Integer totalGpa;

}
