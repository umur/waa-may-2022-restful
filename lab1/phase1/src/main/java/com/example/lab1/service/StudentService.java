package com.example.lab1.service;

import com.example.lab1.entity.Course;
import com.example.lab1.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    void delete(int id);
    void update(int id, Student studentUpdate);
    List<Student> getAll();
    Student getById(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
