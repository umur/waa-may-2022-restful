package com.example.lab1.controller;

import com.example.lab1.entity.Course;
import com.example.lab1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public void save(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Course courseUpdate){
        courseService.update(id, courseUpdate);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getById(id);
    }

}
