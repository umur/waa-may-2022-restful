package com.example.phase1.service;

import com.example.phase1.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    void save(Student s);

    void update(Student s);

    void delete(int id);

    Student getById(int id);

}
