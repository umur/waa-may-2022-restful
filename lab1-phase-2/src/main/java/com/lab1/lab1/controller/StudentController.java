package com.lab1.lab1.controller;

import com.lab1.lab1.dto.CourseDto;
import com.lab1.lab1.dto.StudentDto;
import com.lab1.lab1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.status(200).body(studentService.getAll());
    }



    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id) {
        return ResponseEntity.status(200).body(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PostMapping(value = "/", consumes = {"*/*"})
    public void save(@RequestBody StudentDto s) {
        studentService.save(s);
    }

    @GetMapping(value = "/api/v2/students/{major}")
    public List<StudentDto> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping(value = "/api/v2/students/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

//    @PutMapping("/{id}")
//    public void update(@RequestBody Student s, @PathVariable int id) {
//        studentService.update(s, id);
//    }
}
