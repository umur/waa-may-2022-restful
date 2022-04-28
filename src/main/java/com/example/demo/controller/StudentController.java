package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/api/v1/students")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.status(200).body(studentService.getAll());
    }
    @GetMapping("/api/v2/students")
    public ResponseEntity<List<Student>> getAllV2(@RequestParam String major) {
        return ResponseEntity.status(200).body(studentService.getAllV2(major));
    }
    @GetMapping("/api/v2/students/{id}/courses")
    public ResponseEntity<List<Course>> getCourseByStudentID(@PathVariable int id) {
        return ResponseEntity.status(200).body(studentService.getCourseTaken(id));
    }
    @GetMapping("/api/v1/students/{id}")
    public ResponseEntity<Student> getByID(@PathVariable int id ) {
        return ResponseEntity.status(200).body(null);
    }

    @PostMapping("/api/v1/students")
    public ResponseEntity<String> save(@RequestBody Student stu ) {
        Boolean result = studentService.save(stu);
        if(result==true){
            return ResponseEntity.status(200).body("Success");
        }
       return ResponseEntity.status(409).body("Already exist");
    }

    @PutMapping("/api/v1/students/{id}")
    public ResponseEntity<List<Student>> update(@RequestBody Student stu ,@PathVariable int id) {
        List<Student> result = studentService.update(stu,id);
        return ResponseEntity.status(200).body(result);
    }
    @DeleteMapping("/api/v1/students/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        studentService.delete(id);
        return ResponseEntity.status(200).body("Success");
    }

}
