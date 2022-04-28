package com.example.assignment1phase1.entity;

import lombok.Data;

import java.util.List;
@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String major;
    private List<Course> coursesTaken;
    private String gpa;
}
