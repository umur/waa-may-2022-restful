package com.pprajapati.server.service;

import com.pprajapati.server.domain.Student;

import java.util.List;

public interface StudentService {
    void save(Student s);
    void delete(int id);
    List<Student> getAll();
    Student getById(int id);
    void update(int id, Student s);
}
