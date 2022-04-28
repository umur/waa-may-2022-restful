package com.vkarki.labone.controller;

import com.vkarki.labone.domain.Course;
import com.vkarki.labone.domain.Student;
import com.vkarki.labone.dto.SimpleCourseDto;
import com.vkarki.labone.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public void save(@RequestBody SimpleCourseDto course) {
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody SimpleCourseDto course, @PathVariable int id) {
        courseService.update(course, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

    @GetMapping
    public List<SimpleCourseDto> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public SimpleCourseDto getById(@PathVariable int id) {
        return courseService.getById(id);
    }

}
