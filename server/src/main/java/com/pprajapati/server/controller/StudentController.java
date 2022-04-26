package com.pprajapati.server.controller;

import com.pprajapati.server.domain.Student;
import com.pprajapati.server.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void save(@RequestBody Student s){
        studentService.save(s);
    }

    @GetMapping
    public List<Student> getAll(){
        return  studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student s){
        studentService.update(id, s);
    }


}
