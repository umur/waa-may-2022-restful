package com.example.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
public class Student {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String major;
    public List<Course> courseTaken;
    public boolean deleted;


    public Student(int id, String firstName, String lastName, String email, String major, List<Course> courseTaken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.courseTaken = courseTaken;
    }
}
