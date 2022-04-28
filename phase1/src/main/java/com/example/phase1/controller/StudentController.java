package com.example.phase1.controller;

import com.example.phase1.domain.Student;
import com.example.phase1.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentServiceImpl studentService;

    @PostMapping
    public void saveStudent(@RequestBody Student s) {
        studentService.save(s);
    }


}
