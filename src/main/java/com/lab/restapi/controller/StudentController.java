package com.lab.restapi.controller;

import com.lab.restapi.dto.StudentDto;
import com.lab.restapi.entity.Course;
import com.lab.restapi.entity.Student;
import com.lab.restapi.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/v1/students")
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @PostMapping("/v1/students")
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @PostMapping("/v1/students/stu")
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @PostMapping("/v2/students")
    public void saveWithGPA(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping("/v2/students/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/v2/students/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/v1/students/{id}")
    public Student getById(@PathVariable long id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/v1/students/{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }

    @PostMapping("/v1/students/add/{id}")
    public void saveCourse(@RequestBody Course course) {

    }
}
