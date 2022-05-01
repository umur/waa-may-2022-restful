package com.example.phase2.controller;


import com.example.phase2.domain.Course;
import com.example.phase2.dto.CourseDto;
import com.example.phase2.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    private CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping
    public List<CourseDto> getAll(){
        return  courseService.getAll();
    }

    @PostMapping
    public void save(@RequestBody CourseDto course){
        courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

    }

    @PutMapping("/{id}")
    public void update(@RequestBody Course c, @PathVariable int id) {

    }
}
