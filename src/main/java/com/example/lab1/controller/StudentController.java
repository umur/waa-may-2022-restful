package com.example.lab1.controller;

import com.example.lab1.adapters.StudentAdapter;
import com.example.lab1.customError.CustomError;
import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTOV1;
import com.example.lab1.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;

    public StudentController(StudentService studentService,
                             ModelMapper modelMapper){
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam Map<String, String> queryParams){

        Optional<Collection<Student>> students = Optional.ofNullable(studentService.getStudents());
        if(students.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Collection<StudentDTOV1> studentDTOV1s;
        studentDTOV1s = students
                .get()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTOV1.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(studentDTOV1s, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id){
        Optional<Student> student = Optional.ofNullable(studentService.getStudent(id));
        if(student.isPresent())
            return new ResponseEntity<>(modelMapper.map(student.get(), StudentDTOV1.class), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(
                modelMapper.map(studentService.createStudent(student), StudentDTOV1.class),
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
        Optional<Student> student = Optional.ofNullable(studentService.getStudent(id));
        if(student.isPresent())
            return new ResponseEntity<>(
                    modelMapper.map(studentService.addCourse(id, course), StudentDTOV1.class),
                    HttpStatus.CREATED);
        return new ResponseEntity<>(new CustomError("Student Not Found"), HttpStatus.NOT_FOUND);
    }

}
