package com.example.phase1.controller;

import com.example.phase1.domain.Course;
import com.example.phase1.domain.Student;
import com.example.phase1.service.StudentService;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    private StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @CrossOrigin("http://localhost:63342/")
    @PostMapping
    public List<Student> save(@RequestBody Student student){

        studentService.save(student);
        return  getAll();
    }

    @PostMapping("api/v2/students")
    public List<Student> saveV2(@RequestBody Student student){

        studentService.saveV2(student);
        return  getAll();
    }

    @GetMapping("api/v2/students/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getByMajor(major);

    }

    @GetMapping("api/v2/students/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getStudentCourses(id);

    }
}
