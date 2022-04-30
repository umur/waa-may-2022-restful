package edu.miu.phase2.controller;

import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.entity.Course;
import edu.miu.phase2.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courses = courseService.getAll();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable int id) {
        CourseDto course = courseService.getById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public void save(@RequestBody CourseDto course) {
        courseService.save(course);
    }

    @PutMapping("{id}")
    public void update(@RequestBody CourseDto course, @PathVariable int id) {
        courseService.update(course, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);

    }
}
