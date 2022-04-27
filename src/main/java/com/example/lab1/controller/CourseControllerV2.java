package com.example.lab1.controller;

import com.example.lab1.domain.Course;
import com.example.lab1.dtos.CourseDTOV1;
import com.example.lab1.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/courses")
public class CourseControllerV2 {

    private final CourseService courseService;

    public CourseControllerV2(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<?> getCourseByStudentId(@PathVariable long id) {
        List<CourseDTOV1> course = courseService.getCourseByStudentId(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}
