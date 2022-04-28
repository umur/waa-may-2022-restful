package com.example.assignment1phase1.controller;

import com.example.assignment1phase1.dto.StudentDto;
import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.entity.Student;
import com.example.assignment1phase1.service.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id) {
        return studentServiceImpl.getById(id);
    }


    @GetMapping
    public List<StudentDto> getAll() {
        return studentServiceImpl.getAll();
    }

    @PostMapping()
    public void save(@RequestBody StudentDto s) {
        studentServiceImpl.save(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentServiceImpl.delete(id);
    }
    @GetMapping( "/api/v2/students/{major}")
    public List<StudentDto> getStudentsByMajor(@PathVariable String major){
        System.out.println("hiiii");
return studentServiceImpl.getStudentsByMajor(major);
    }

    @GetMapping( "/api/v2/students/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable  int studentId) {
        System.out.println("hi");
        return studentServiceImpl.getCoursesByStudentId(studentId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@RequestBody StudentDto s, @PathVariable int id) {
       return ResponseEntity.status(403).body( studentServiceImpl.update(s, id));
    }

}
