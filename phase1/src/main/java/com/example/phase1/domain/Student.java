package com.example.phase1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;

    private List<Course> coursesTaken;

}
