package com.vkarki.labone.controller;

import com.vkarki.labone.domain.Student;
import com.vkarki.labone.dto.SimpleStudentDto;
import com.vkarki.labone.dto.SimpleStudentDtoV2;
import com.vkarki.labone.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("api/v1/students")
    public void save(@RequestBody SimpleStudentDto student) {
        studentService.save(student);
    }

    @PutMapping("api/v1/students/{id}")
    public void update(@RequestBody SimpleStudentDto student, @PathVariable int id) {
        studentService.update(student, id);
    }

    @DeleteMapping("api/v1/students/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @GetMapping("api/v1/students")
    public List<SimpleStudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("api/v2/students")
    public List<SimpleStudentDtoV2> getAllV2() {
        return studentService.getAllV2();
    }

    @GetMapping("api/v1/students/{id}")
    public SimpleStudentDto getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @GetMapping("api/v2/students/by_major")
    public List<SimpleStudentDtoV2> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

}
