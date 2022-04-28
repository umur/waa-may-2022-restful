package com.example.assignment1phase1.controller;

import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.entity.Student;
import com.example.assignment1phase1.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private CourseServiceImpl courseServiceImpl;

    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping
    public List<Course> getAll() {
        return courseServiceImpl.getAll();

    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return courseServiceImpl.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable int id)
    {
        courseServiceImpl.delete(id);
    }
    @PutMapping("{id}")
    public Course update(@RequestBody Course c,@PathVariable int id){
        return courseServiceImpl.update(c,id);

    }
    @PostMapping()
    public void save(@RequestBody Course c)
    {
        System.out.println("hi");
        courseServiceImpl.save(c);
    }


}
