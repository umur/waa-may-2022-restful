package com.example.phase2.dto;

import com.example.phase2.domain.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class StudentDto {

    private String firstName;
    private String lastName;
    private String email;
    private String major;

    private List<CourseDto> coursesTaken;

}
