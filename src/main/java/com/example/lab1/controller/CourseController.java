package com.example.lab1.controller;

import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.CourseDTOV1;
import com.example.lab1.dtos.StudentDTOV1;
import com.example.lab1.service.CourseService;
import com.example.lab1.service.CourseServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }



    @PostMapping()
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable long id , @RequestBody Course course){
        courseService.updateCourse(id , course);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> getCourses(){
        List<CourseDTOV1> courseList = courseService.getCourses();
           return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable long id){
        Optional<CourseDTOV1> course = courseService.getCourse(id);
        if(course.isPresent())
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
