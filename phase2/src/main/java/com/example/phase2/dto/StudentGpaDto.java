package com.example.phase2.dto;

import com.example.phase2.entity.Course;

import java.util.List;

public class StudentGpaDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private float gpa;
}
