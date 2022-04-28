package com.example.phase1.service;

import com.example.phase1.domain.Student;
import com.example.phase1.domain.Student2;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    List<Student2> getAll2();

    List<Student2> getStudentByMajor(String major);

    void save(Student s);

    void save2(Student2 s);
    void update(Student s, int id);

    void delete(int id);

    Student getById(int id);

}
