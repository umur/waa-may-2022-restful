package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.status(200).body(studentService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getByID(@PathVariable int id ) {
        return ResponseEntity.status(200).body(null);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Student stu ) {
        Boolean result = studentService.save(stu);
        if(result==true){
            return ResponseEntity.status(200).body("Success");
        }
       return ResponseEntity.status(409).body("Already exist");
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Student>> update(@RequestBody Student stu ,@PathVariable int id) {
        List<Student> result = studentService.update(stu,id);
        return ResponseEntity.status(200).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        studentService.delete(id);
        return ResponseEntity.status(200).body("Success");
    }
}
