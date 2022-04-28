package com.example.phase1.controller;

import com.example.phase1.domain.Student;
import com.example.phase1.domain.Student2;
import com.example.phase1.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/v1/students")
    public void saveStudent(@RequestBody Student s) {
        studentService.save(s);
    }

    @PostMapping(value = "/v2/students")
    public void saveStudent2(@RequestBody Student2 s) {
        studentService.save2(s);
    }

    @GetMapping(value = "/v2/students")
    public List<Student2> getAll2() {
        return studentService.getAll2();
    }

    @GetMapping(value = "/v1/students")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/v2/students/{major}")
    public List<Student2> getStudentByMajor(@PathVariable String major) {
        return studentService.getStudentByMajor(major);
    }

    @PutMapping("/v1/students/{id}")
    public void update(@RequestBody Student s, @PathVariable int id) {
        studentService.update(s, id);
    }

    @DeleteMapping("/v1/students/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

}
