package com.example.lab1.controller;

import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam Map<String, String> queryParams){
        Optional<List<Student>> studentList = Optional.ofNullable(studentService.getStudents());
        if(studentList.isPresent())
           return new ResponseEntity<>(studentList, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id){
        Optional<Student> student = Optional.ofNullable(studentService.getStudent(id));
        if(student.isPresent())
            return new ResponseEntity<>(student, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyStudent(@PathVariable long id, @RequestBody Student student){
        studentService.modifyStudent(id, student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/courses")
    public ResponseEntity<?> addCourse(@PathVariable long id, @RequestBody Course course){
        return new ResponseEntity<>(studentService.addCourse(id, course), HttpStatus.CREATED);
    }

}
