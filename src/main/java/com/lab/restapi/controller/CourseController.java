package com.lab.restapi.controller;

import com.lab.restapi.dto.CourseDto;
import com.lab.restapi.entity.Course;
import com.lab.restapi.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable long id) {
        return courseService.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        courseService.delete(id);
    }
}
