package com.example.lab1.dto;

import com.example.lab1.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private double gpa;
}
