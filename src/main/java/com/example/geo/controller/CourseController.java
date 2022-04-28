package com.example.geo.controller;

import com.example.geo.Utilities.ModelMapperUti;
import com.example.geo.domain.Course;
import com.example.geo.domain.dto.CourseDto;
import com.example.geo.service.impl.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAll();
     }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable int id) {
        return courseService.getById(id);
    }


    // /products/5 DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CourseDto p, @PathVariable int id) {
        courseService.update(id,p);
    }

    @PostMapping
    public void save(@RequestBody CourseDto p) {
        courseService.save(p);
    }

}