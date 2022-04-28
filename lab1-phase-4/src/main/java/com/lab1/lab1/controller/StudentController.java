package com.lab1.lab1.controller;

import com.lab1.lab1.dto.CourseDto;
import com.lab1.lab1.dto.StudentDto;
import com.lab1.lab1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("v1/students")
    public String getAll(Model model) {
        model.addAttribute("listStudents", studentService.getAll());
        return "index";
    }



    @GetMapping("v1/students/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id) {
        return ResponseEntity.status(200).body(studentService.getById(id));
    }

    @DeleteMapping("v1/students/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PostMapping("v1/students")
    public void save(@RequestBody StudentDto s) {
        studentService.save(s);
    }

    @GetMapping("v2/students/{major}")
    public List<StudentDto> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("v2/students/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

//    @PutMapping("/{id}")
//    public void update(@RequestBody Student s, @PathVariable int id) {
//        studentService.update(s, id);
//    }
}
