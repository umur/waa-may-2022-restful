package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    void save(StudentDto s);

    void delete(int id);

    List<StudentDto> getAll();

    StudentDto getById(int id);
    void update(int id, StudentDto s);

    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int id);
}
