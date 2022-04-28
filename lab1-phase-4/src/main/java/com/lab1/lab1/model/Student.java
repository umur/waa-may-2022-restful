package com.lab1.lab1.model;

import lombok.*;

import java.util.List;


@Data
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private float gpa;

}
