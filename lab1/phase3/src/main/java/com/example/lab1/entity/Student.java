package com.example.lab1.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private double gpa;

    public Student(int id, String firstname, String lastname, String email, String major, List<Course> coursesTaken) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.major = major;
        this.coursesTaken = coursesTaken;
    }
}
