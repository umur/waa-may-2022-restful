package com.pprajapati.server.controller;

import com.pprajapati.server.dto.CourseDto;
import com.pprajapati.server.dto.StudentDto;
import com.pprajapati.server.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void save(@RequestBody StudentDto s){
        studentService.save(s);
    }

    @GetMapping
    public List<StudentDto> getAll(){
        return  studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody StudentDto s){
        studentService.update(id, s);
    }

    @GetMapping(value = "/api/v2/students/major/{major}")
    public List<StudentDto> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping(value = "/api/v2/students/courses/{studentId}")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }


}
