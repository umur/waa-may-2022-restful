package com.example.phase2.controller;

import com.example.phase2.dto.CourseDto;
import com.example.phase2.dto.StudentDto;
import com.example.phase2.dto.StudentGpaDto;
import com.example.phase2.service.impl.StudentServiceImpl;
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
    public void saveStudent(@RequestBody StudentDto s) {
        studentService.save(s);
    }

    @PostMapping(value = "/v2/students")
    public void saveStudent2(@RequestBody StudentGpaDto s) {
        studentService.save2(s);
    }

    @GetMapping(value = "/v2/students")
    public List<StudentGpaDto> getAll2() {
        return studentService.getAll2();
    }

    @GetMapping(value = "/v1/students")
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/v2/students/{major}")
    public List<StudentGpaDto> getStudentByMajor(@PathVariable String major) {
        return studentService.getStudentByMajor(major);
    }

    @GetMapping(value = "/v2/students/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

    @PutMapping("/v1/students/{id}")
    public void update(@RequestBody StudentDto s, @PathVariable int id) {
        studentService.update(s, id);
    }

    @DeleteMapping("/v1/students/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

}
