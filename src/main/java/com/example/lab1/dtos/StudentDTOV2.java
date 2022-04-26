package com.example.lab1.dtos;

import com.example.lab1.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTOV2 {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private double gpa;

    public void addCourse(Course course){
        if(coursesTaken == null)
            coursesTaken = new ArrayList<>();
        coursesTaken.add(course);
    }
}
