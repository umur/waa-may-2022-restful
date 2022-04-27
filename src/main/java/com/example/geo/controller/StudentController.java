package com.example.geo.controller;

import com.example.geo.domain.Course;
import com.example.geo.domain.Student;
import com.example.geo.service.impl.CourseService;
import com.example.geo.service.impl.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
        // return productService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }


    // /products/5 DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Student p, @PathVariable int id) {
        studentService.update(id, p);
    }

    @PostMapping
    public void save(@RequestBody Student p) {
        studentService.save(p);
    }

    @GetMapping("/api/v2/students/search")
    public List<Student> getStudentsByMajor(@RequestParam("major") String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/api/v2/students/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
}