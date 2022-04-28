package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void save( @RequestBody CourseDto c){
        courseService.save(c);
    }

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable int id) {
        return ResponseEntity.ok( courseService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CourseDto c){
        courseService.update(id,c);
    }


}
