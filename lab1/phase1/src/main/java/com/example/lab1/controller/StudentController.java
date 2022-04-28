package com.example.lab1.controller;

import com.example.lab1.entity.Student;
import com.example.lab1.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student studentUpdate){
        studentService.update(id, studentUpdate);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

}
