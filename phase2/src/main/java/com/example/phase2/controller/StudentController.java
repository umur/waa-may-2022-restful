package com.example.phase2.controller;

import com.example.phase2.domain.Student;
import com.example.phase2.dto.StudentDto;
import com.example.phase2.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    private StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping
    public List<StudentDto> getAll(){

        return studentService.getAll();
    }

    @CrossOrigin("http://localhost:63342/")
    @PostMapping
    public List<StudentDto> save(@RequestBody StudentDto studentDto){

        studentService.save(studentDto);
        return  getAll();
    }
}
