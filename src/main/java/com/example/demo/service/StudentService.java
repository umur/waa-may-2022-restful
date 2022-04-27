package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student s);

    void delete(int id);

    List<Student> getAll();

    Student getById(int id);
    void update(int id, Student s);

    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);
}
