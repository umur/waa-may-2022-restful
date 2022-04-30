package edu.miu.phase2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String major;
    private List<Course> coursesTaken;
    private double gpa;

    public Student(int id, String firstName, String lastName, String email, String major){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = email;
        this.major = major;
        this.coursesTaken = new ArrayList<>();
    }

    public void addCourse(Course course){
        this.coursesTaken.add(course);
    }



}
