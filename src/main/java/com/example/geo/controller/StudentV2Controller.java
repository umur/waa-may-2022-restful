package com.example.geo.controller;

import com.example.geo.Utilities.ModelMapperUti;
import com.example.geo.domain.dto.CourseDto;
import com.example.geo.domain.dto.StudentDto;
import com.example.geo.service.impl.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v2/students")
public class StudentV2Controller {
    private final StudentService studentService;
    private final ModelMapperUti modelMapperUti;

    @GetMapping("/search")
    public List<StudentDto> getStudentsByMajor(@RequestParam("major") String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
}