package com.vkarki.labone.dto;

import com.vkarki.labone.domain.Course;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SimpleStudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<SimpleCourseDto> coursesTaken = new ArrayList<>();
}
