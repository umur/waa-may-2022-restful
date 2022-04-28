package com.example.assignment1phase1.service;

import com.example.assignment1phase1.dto.StudentDto;
import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public interface StudentService {
     List<StudentDto> getAll();
    StudentDto getById(int id);
    void save(StudentDto s);

    void delete(int id);

    StudentDto update(StudentDto s,int id);

     List<StudentDto> getStudentsByMajor(String major) ;
     List<Course> getCoursesByStudentId(int studentId) ;

}
