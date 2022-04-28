package com.vkarki.labone.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SimpleStudentDtoV2 {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<SimpleCourseDto> coursesTaken = new ArrayList<>();
}
