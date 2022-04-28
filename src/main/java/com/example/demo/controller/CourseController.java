package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.status(200).body(courseService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getByID(@PathVariable int id ) {
        return ResponseEntity.status(200).body(null);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Course cou ) {
         courseService.save(cou);
         return ResponseEntity.status(200).body("Success");

    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Course>> update(@RequestBody Course cou ,@PathVariable int id) {
        List<Course> result = courseService.update(cou,id);
        return ResponseEntity.status(200).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        courseService.delete(id);
        return ResponseEntity.status(200).body("Success");
    }
}
