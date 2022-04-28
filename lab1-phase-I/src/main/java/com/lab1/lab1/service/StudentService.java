package com.lab1.lab1.service;

import com.lab1.lab1.model.Course;
import com.lab1.lab1.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    void save(Student s);
    void delete(int id);
    List<Student> getAll();
    Student getById(int id);
    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int id);
}
