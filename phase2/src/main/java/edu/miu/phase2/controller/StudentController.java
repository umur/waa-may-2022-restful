package edu.miu.phase2.controller;

import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.dto.StudentDto;
import edu.miu.phase2.entity.Course;
import edu.miu.phase2.entity.Student;
import edu.miu.phase2.service.StudentService;
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
    public ResponseEntity<List<StudentDto>> getAll() {
        List<StudentDto> students = studentService.getAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/api/v1/students/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id) {
        StudentDto student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/api/v1/students")
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @PutMapping("/api/v1/students/{id}")
    public void update(@RequestBody StudentDto student, @PathVariable int id) {
        studentService.update(student, id);
    }

    @DeleteMapping("/api/v1/students/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @GetMapping("/api/v2/students/{id}/courses")
    public ResponseEntity<List<CourseDto>> getCoursesByStudentId(@PathVariable int id) {
        List<CourseDto> coursesForStudent = studentService.getCoursesByStudentId(id);
        return ResponseEntity.ok().body(coursesForStudent);
    }

    @GetMapping("/api/v2/students")
    public ResponseEntity<List<StudentDto>> getStudentsByMajor(@RequestParam String major) {
        List<StudentDto> students = studentService.getStudentsByMajor(major);
        return ResponseEntity.ok().body(students);
    }








}
