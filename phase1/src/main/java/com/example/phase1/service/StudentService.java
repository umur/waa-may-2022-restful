package com.example.phase1.service;


import com.example.phase1.domain.Course;
import com.example.phase1.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    List<Student> getByMajor(String major);

    List<Course> getStudentCourses(int id);

    void save(Student s);
    void saveV2(Student s);
}
