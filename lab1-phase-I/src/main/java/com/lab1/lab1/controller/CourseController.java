package com.lab1.lab1.controller;

import com.lab1.lab1.model.Course;
import com.lab1.lab1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private static CourseService courseService;

    @GetMapping("/")
    public ResponseEntity<List<Course>> getAll(){
        return ResponseEntity.status(200).body(courseService.getAll());
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id) {
        return courseService.getById(id);
    }
    @PostMapping("/")
    public  void save(@RequestBody Course c) {
        courseService.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }


}
