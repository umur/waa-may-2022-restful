package com.vkarki.labone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken = new ArrayList<>();
    private boolean deleted;
    private double gpa;


    public void addCourse(Course course) {
        coursesTaken.add(course);
    }

}
