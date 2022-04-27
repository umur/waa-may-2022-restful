package com.example.geo.controller;

import com.example.geo.domain.Course;
import com.example.geo.service.impl.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
//        List<Course> list=new ArrayList<>();
//        Course c=new Course();
//        c.setId(1);
//        c.setCode("CS545");
//        c.setName("WAA");
//        list.add(c);
//                return  list;
        return courseService.getAll();
        // return productService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id) {
        return courseService.getById(id);
    }


    // /products/5 DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Course p, @PathVariable int id) {
        courseService.update(id,p);
    }

    @PostMapping
    public void save(@RequestBody Course p) {
        courseService.save(p);
    }

}