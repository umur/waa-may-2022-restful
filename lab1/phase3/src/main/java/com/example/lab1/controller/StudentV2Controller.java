package com.example.lab1.controller;

import com.example.lab1.dto.CourseDTO;
import com.example.lab1.dto.StudentDTO;
import com.example.lab1.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/students")
public class StudentV2Controller {

    private final StudentService studentService;

    public StudentV2Controller(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(path = "/get-by-major")
    public List<StudentDTO> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping(path = "/get-course-by-id")
    public List<CourseDTO> getCoursesByStudentId(@RequestParam int id){
        return studentService.getCoursesByStudentId(id);
    }

}
