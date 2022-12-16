package com.example.lab2.dto;

import com.example.lab2.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String major;
    public List<Course> courseTaken;

}
