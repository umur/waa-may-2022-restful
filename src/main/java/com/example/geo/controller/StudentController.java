package com.example.geo.controller;

import com.example.geo.Utilities.ModelMapperUti;
import com.example.geo.domain.Course;
import com.example.geo.domain.Student;
import com.example.geo.domain.dto.CourseDto;
import com.example.geo.domain.dto.StudentDto;
import com.example.geo.service.impl.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    private final ModelMapperUti modelMapperUti;
    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id) {
        return studentService.getById(id);
    }


    // /products/5 DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody StudentDto p, @PathVariable int id) {
        studentService.update(id, p);
    }

    @PostMapping
    public void save(@RequestBody StudentDto p) {
        studentService.save(p);
    }

    @GetMapping("/api/v2/students/search")
    public List<StudentDto> getStudentsByMajor(@RequestParam("major") String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/api/v2/students/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
}