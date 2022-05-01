package com.example.phase1.controller;


import com.example.phase1.domain.Course;
import com.example.phase1.service.CourseService;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    private CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping
    public List<Course> getAll(){
        return  courseService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Course course){
        courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Course c, @PathVariable int id) {
        courseService.update(c, id);
    }
}
