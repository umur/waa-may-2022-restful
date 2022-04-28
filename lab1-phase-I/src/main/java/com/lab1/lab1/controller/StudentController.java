package com.lab1.lab1.controller;

import com.lab1.lab1.model.Course;
import com.lab1.lab1.model.Student;
import com.lab1.lab1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("v1/students")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.status(200).body(studentService.getAll());
    }



    @GetMapping("v1/students/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        return ResponseEntity.status(200).body(studentService.getById(id));
    }

    @DeleteMapping("v1/students/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PostMapping("v1/students")
    public void save(@RequestBody Student s) {
        studentService.save(s);
    }

    @GetMapping("v2/students/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("v2/students/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

//    @PutMapping("/{id}")
//    public void update(@RequestBody Student s, @PathVariable int id) {
//        studentService.update(s, id);
//    }
}
