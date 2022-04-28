package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/students")
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public void save(@RequestBody StudentDto s){
        studentService.save(s);
    }

    @GetMapping
    public List<StudentDto> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody StudentDto s){
        studentService.update(id,s);
    }

}
