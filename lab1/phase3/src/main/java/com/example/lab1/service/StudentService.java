package com.example.lab1.service;

import com.example.lab1.dto.CourseDTO;
import com.example.lab1.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    void save(StudentDTO student);
    void delete(int id);
    void update(int id, StudentDTO studentUpdate);
    List<StudentDTO> getAll();
    StudentDTO getById(int id);
    List<StudentDTO> getStudentsByMajor(String major);
    List<CourseDTO> getCoursesByStudentId(int studentId);
}
