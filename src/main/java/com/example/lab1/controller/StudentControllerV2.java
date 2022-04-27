package com.example.lab1.controller;

import com.example.lab1.customError.CustomError;
import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTOV2;
import com.example.lab1.service.impl.StudentServiceImplV1;
import com.example.lab1.service.impl.StudentServiceImplV2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v2/students")
public class StudentControllerV2 {
    private final StudentServiceImplV2 studentService;

    public StudentControllerV2(StudentServiceImplV2 studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam Map<String, String> queryParams){
        if(queryParams.containsKey("major")){
            return new ResponseEntity<>(studentService.getStudentsByMajor(queryParams.get("major")), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
        }
    }


    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getCoursesByStudentId(@PathVariable long id){
         Optional<Collection<Course>> courses = Optional.ofNullable(studentService.getCoursesByStudentId(id));
         return courses.isPresent() ?
                 new ResponseEntity<>(courses, HttpStatus.OK) :
                 new ResponseEntity<>(new CustomError("No courses found for student"), HttpStatus.NOT_FOUND);
    }

}
