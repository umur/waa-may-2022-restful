package com.example.lab2.controller;

import com.example.lab2.dto.StudentDto;
import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    public final StudentService service;
    @GetMapping
    public List<StudentDto> getAll(){
      return service.getAllStudent();
    }


    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteStudentById(id);
    }

    @GetMapping("/{major}/major")
    public List<StudentDto> getByMajor(@PathVariable String major){
        return service.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/course")
    public List<Course> getCourseById(@PathVariable int id){
        return service.getCoursesByStudentId(id);
    }
}
