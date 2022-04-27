package com.example.lab1.controller;

import com.example.lab1.customError.CustomError;
import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTO;
import com.example.lab1.service.impl.StudentServiceImplV1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentControllerV1 {

    private final StudentServiceImplV1 studentService;

    public StudentControllerV1(StudentServiceImplV1 studentService){ this.studentService = studentService;}

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestHeader Map<String, String> headers,
                                         @RequestParam Map<String, String> queryParams){
        Optional<Collection<StudentDTO>> students = Optional.ofNullable(studentService.getStudents());
        return new ResponseEntity<>(students.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id){
        Optional<StudentDTO> student = Optional.ofNullable(studentService.getStudent(id));
        if(student.isPresent())
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student),
                                    HttpStatus.CREATED);
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
        Optional<StudentDTO> student = Optional.ofNullable(studentService.getStudent(id));
        if(student.isPresent())
            return new ResponseEntity<>(studentService.addCourse(id, course),
                                        HttpStatus.CREATED);
        return new ResponseEntity<>(new CustomError("Student Not Found"), HttpStatus.NOT_FOUND);
    }

}
