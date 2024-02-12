package com.workintech.Chalenge17.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private Integer id;
    private String name;
    private Integer credit;
    private  Grade grade;


    public String getName() {
        return getName();
    }

    public Integer getCredit() {
        return getCredit();
    }

    public Grade getGrade() {
        return getGrade();
    }

    public Integer getId(){
        return getId();
    }
}
