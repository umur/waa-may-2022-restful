package com.waa.phase1.controller;

import com.waa.phase1.dto.CourseDto;
import com.waa.phase1.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDto> save(@RequestBody CourseDto c) {
        courseService.save(c);
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable Long id) {
        var course = courseService.getById(id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long courseId, @RequestBody CourseDto c) {
        courseService.update(courseId, c);
    }
}
