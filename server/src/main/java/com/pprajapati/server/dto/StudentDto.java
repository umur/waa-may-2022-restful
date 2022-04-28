package com.pprajapati.server.dto;

import com.pprajapati.server.domain.Course;

import java.util.List;

public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;

    private char gpa;
    private List<Course> coursesTaken;

    public StudentDto(){}

    public StudentDto(int id, String firstName, String lastName, String email, String major, char gpa, List<Course> coursesTaken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.coursesTaken = coursesTaken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public char getGpa() {
        return gpa;
    }

    public void setGpa(char gpa) {
        this.gpa = gpa;
    }

    public List<Course> getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(List<Course> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }
}
