package com.workintech.Chalenge17.controller;

import com.workintech.Chalenge17.entity.Course;
import com.workintech.Chalenge17.entity.CourseGpa;
import com.workintech.Chalenge17.exceptions.ApiExceptions;
import com.workintech.Chalenge17.validations.CourseValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/courses")
public class CourseController {
    private List<Course> courses;

    private final CourseGpa low;
    private  final CourseGpa mid;
    private  final CourseGpa high;

    public  CourseController(@Qualifier("low") CourseGpa low,
                             @Qualifier("mid") CourseGpa mid,
                             @Qualifier("high") CourseGpa high){
        this.low=low;
        this.mid=mid;
        this.high=high;
    }


    @PostConstruct
    public void  init(){
        this.courses= new ArrayList<>();
    }

    @GetMapping
    public List<Course> getAll(){
        return this.courses;
    }

    @GetMapping("/{name}")
    public Course getByName(@PathVariable("name") String name){
        CourseValidation.checkName(name);
        return courses.stream()
                .filter(course -> course.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(()-> new ApiExceptions("course not found"+name, HttpStatus.NOT_FOUND));
    }


@PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody Course course){
        CourseValidation.checkCredit(course.getCredit());
        CourseValidation.checkName(course.getName());
        courses.add(course);
        course.getCredit();
        Integer TotalGpa = getTotalGpa(course);
        ApiResponse apiResponse= new ApiResponse(course, totalGpa);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    private Integer getTotalGpa(Course course) {
        if (course.getCredit() <= 2) {
            course.getGrade().getCoefficient() * course.getCredit() * low.getGpa()
        } else if (course.getCredit() == 3) {
            course.getGrade().getCoefficient() * course.getCredit() * mid.getGpa()
        } else if (course.getCredit() == 4) {
            course.getGrade().getCoefficient() * course.getCredit() * high.getGpa()

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Integer id, @RequestBody Course course){
        CourseValidation.checkId(id);
        CourseValidation.checkCredit(course.getCredit());
        CourseValidation.checkName(course.getName());
        Course existingCourse = courses.stream()
                .filter(course1 -> course1.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ApiExceptions(("not id", HttpStatus.BAD_REQUEST));
        int idexOfExistingCourse= courses.indexOf(existingCourse);
        course.setId(id);
        courses.set(idexOfExistingCourse,course);
        Integer totalGpa = getTotalGpa();
        ApiResponse apiResponse= new ApiResponse()(courses.get(idexOfExistingCourse) ,totalGpa);
        return  new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        Course exsitingCourse = courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ApiExceptions("course not find id", HttpStatus.BAD_REQUEST));
        courses.remove(exsitingCourse);
    }



}
