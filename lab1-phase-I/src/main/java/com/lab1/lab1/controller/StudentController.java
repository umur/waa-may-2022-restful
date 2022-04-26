package com.lab1.lab1.controller;

import com.lab1.lab1.model.Student;
import com.lab1.lab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private static StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        return ResponseEntity.status(200).body(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PostMapping("/")
    public void save(@RequestBody Student s) {
        studentService.save(s);
    }
    
//    @PutMapping("/{id}")
//    public void update(@RequestBody Student s, @PathVariable int id) {
//        studentService.update(s, id);
//    }
}
