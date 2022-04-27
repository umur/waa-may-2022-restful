package com.example.lab1.dtos;

import com.example.lab1.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTOV2 extends  StudentDTOV1{

    private double gpa;
}
