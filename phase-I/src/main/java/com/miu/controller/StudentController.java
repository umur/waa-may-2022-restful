package com.miu.controller;

import com.miu.domain.Student;
import com.miu.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        var students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        var student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Long id){
        var updateStudent = studentService.update(student, id);
        return ResponseEntity.ok(updateStudent);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        student = studentService.save(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
