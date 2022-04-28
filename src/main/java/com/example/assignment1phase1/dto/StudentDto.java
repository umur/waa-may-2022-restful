package com.example.assignment1phase1.dto;

import com.example.assignment1phase1.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String major;
    private List<Course> coursesTaken;
}
