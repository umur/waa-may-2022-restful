package com.lab.Restful.controller;

import com.lab.Restful.dto.StudentDto;
import com.lab.Restful.entity.Course;
import com.lab.Restful.entity.Student;
import com.lab.Restful.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping(value = "/{major}/param", params = "version=2")
    public List<StudentDto> getStudentsByMajor(String major){
        return studentService.getStudentsByMajor(major);
    }
    @GetMapping(value = "/{id}/param", params = "version=3")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesById(id);
    }
    @PostMapping
    public void save(@RequestBody Student s){
        studentService.save(s);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Student s, @PathVariable int id){
        studentService.update(s, id);
    }

    @PutMapping("/{studentId}/{courseId}")
    public void addCourseToStudent(@PathVariable int studentId, @PathVariable int courseId){
        studentService.addClassById(studentId, courseId);
    }
    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id){
        StudentDto s= studentService.getById(id);
        return ResponseEntity.ok(s);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

}
