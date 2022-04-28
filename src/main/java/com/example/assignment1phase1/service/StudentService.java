package com.example.assignment1phase1.service;

import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public interface StudentService {
     List<Student> getAll();
      Student getById(int id);
    void save(Student s);

    void delete(int id);

    Student update(Student s,int id);

     List<Student> getStudentsByMajor(String major) ;
     List<Course> getCoursesByStudentId(int studentId) ;

}
