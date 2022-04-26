package com.example.lab1.controller;

import com.example.lab1.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/students")
public class StudentControllerV2 {
    private final StudentService studentService;

    public StudentControllerV2(StudentService studentService){
        this.studentService = studentService;
    }


}
