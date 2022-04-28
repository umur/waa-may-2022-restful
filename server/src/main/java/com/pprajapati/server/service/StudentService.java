package com.pprajapati.server.service;

import com.pprajapati.server.domain.Course;
import com.pprajapati.server.domain.Student;
import com.pprajapati.server.dto.CourseDto;
import com.pprajapati.server.dto.StudentDto;

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
