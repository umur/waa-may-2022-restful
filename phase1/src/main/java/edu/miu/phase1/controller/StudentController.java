package edu.miu.phase1.controller;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.entity.Student;
import edu.miu.phase1.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/v1/students")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/api/v1/students/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/api/v1/students")
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @PutMapping("/api/v1/students/{id}")
    public void update(@RequestBody Student student, @PathVariable int id) {
        studentService.update(student, id);
    }

    @DeleteMapping("/api/v1/students/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @GetMapping("/api/v2/students/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable int id) {
        List<Course> coursesForStudent = studentService.getCoursesByStudentId(id);
        return ResponseEntity.ok().body(coursesForStudent);
    }

    @GetMapping("/api/v2/students")
    public ResponseEntity<List<Student>> getStudentsByMajor(@RequestParam String major) {
        List<Student> students = studentService.getStudentsByMajor(major);
        return ResponseEntity.ok().body(students);
    }








}
