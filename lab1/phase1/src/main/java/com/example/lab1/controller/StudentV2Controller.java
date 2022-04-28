package com.example.lab1.controller;

import com.example.lab1.entity.Course;
import com.example.lab1.entity.Student;
import com.example.lab1.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/students")
public class StudentV2Controller {

    private final StudentService studentService;

    public StudentV2Controller(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(path = "/get-by-major")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping(path = "/get-course-by-id")
    public List<Course> getCoursesByStudentId(@RequestParam int id){
        return studentService.getCoursesByStudentId(id);
    }

//    @GetMapping( path = "/filter")
//    public List<Student> getStudentsByMajor(@RequestParam Map<String,String> param){
//        String key = param.keySet().toArray()[0].toString();
//        String value = param.get(param.keySet().toArray()[0]);
//
//        return switch(key){
//            case "major" -> studentService.getStudentsByMajor(value);
//            case "course" -> {
//                int id = Integer.parseInt(value);
//                yield studentService.getCoursesByStudentId(1);
//            }
//            default -> null;
//        };
//    }
}
