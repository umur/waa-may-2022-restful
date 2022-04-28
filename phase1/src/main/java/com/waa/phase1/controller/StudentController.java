package com.waa.phase1.controller;

import com.waa.phase1.domain.Course;
import com.waa.phase1.domain.Student;
import com.waa.phase1.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/api/v1/students")
    public void save(@RequestBody Student s) {
        studentService.save(s);
    }

    @GetMapping("/api/v1/students")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/api/v1/students/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        var student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/api/v1/students/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @PutMapping("/api/v1/students/{id}")
    public void update(@PathVariable Long id, @RequestBody Student s) {
        studentService.update(id, s);
    }

    @GetMapping("/api/v2/students")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getByMajor(major);
    }

    @GetMapping("/api/v2/students/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long id) {
        return studentService.getCourseByStudentId(id);
    }

    @PostMapping("/api/v2/students/{id}/courses")
    public ResponseEntity<Student> addStudentCourse(@PathVariable Long id, @RequestBody Course c) {
        studentService.addCourse(id, c.getId());
        return ResponseEntity.ok(studentService.getById(id));
    }
}
