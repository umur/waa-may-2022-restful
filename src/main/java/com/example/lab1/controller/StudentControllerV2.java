package com.example.lab1.controller;

import com.example.lab1.customError.CustomError;
import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTOV1;
import com.example.lab1.dtos.StudentDTOV2;
import com.example.lab1.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v2/students")
public class StudentControllerV2 {
    private final StudentService studentService;
    private final ModelMapper modelMapper;

    public StudentControllerV2(StudentService studentService,
                               ModelMapper modelMapper){
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam Map<String, String> queryParams){
        Optional<Collection<Student>> students;
        if(queryParams.containsKey("major")){
            return getStudentByMajor(queryParams.get("major"));
        }else{
            students = Optional.ofNullable(studentService.getStudents());
            if(students.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Collection<StudentDTOV2> studentDTOV2s;
            studentDTOV2s = students.get()
                            .stream()
                            .map(student -> modelMapper.map(student, StudentDTOV2.class))
                            .collect(Collectors.toList());
            return new ResponseEntity<>(studentDTOV2s, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> getStudentByMajor(String major){
        Optional<Collection<Student>> students;
        students = Optional.ofNullable(
                    studentService.getStudentsByMajor(major));
        Collection<StudentDTOV2> students1 = students
                    .get()
                    .stream()
                    .map(student -> modelMapper.map(student, StudentDTOV2.class))
                    .collect(Collectors.toList());
        return new ResponseEntity<>(students1, HttpStatus.OK);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getCoursesByStudentId(@PathVariable long id){
         Optional<Collection<Course>> courses = Optional.ofNullable(studentService.getCoursesByStudentId(id));
         return courses.isPresent() ?
                 new ResponseEntity<>(courses, HttpStatus.OK) :
                 new ResponseEntity<>(new CustomError("No courses found for student"), HttpStatus.NOT_FOUND);
    }

}
