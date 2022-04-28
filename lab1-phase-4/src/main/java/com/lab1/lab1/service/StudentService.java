package com.lab1.lab1.service;

import com.lab1.lab1.dto.CourseDto;
import com.lab1.lab1.dto.StudentDto;

import java.util.List;


public interface StudentService {

    void save(StudentDto s);
    void delete(int id);
    List<StudentDto> getAll();
    StudentDto getById(int id);
    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int id);
}
