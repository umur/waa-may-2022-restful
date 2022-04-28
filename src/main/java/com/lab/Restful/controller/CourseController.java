package com.lab.Restful.controller;

import com.lab.Restful.dto.CourseDto;
import com.lab.Restful.entity.Course;
import com.lab.Restful.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }


    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable int id){
        CourseDto c= courseService.getById(id);
        return ResponseEntity.ok(c);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }
    @PostMapping
    public void save(@RequestBody Course c){
        courseService.save(c);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Course course, @PathVariable int id){
        courseService.update(course ,id);
    }

}
