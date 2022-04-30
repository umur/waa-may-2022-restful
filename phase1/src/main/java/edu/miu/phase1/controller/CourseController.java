package edu.miu.phase1.controller;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.service.CourseService;
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
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAll();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        Course course = courseService.getById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Course course, @PathVariable int id) {
        courseService.update(course, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);

    }
}
