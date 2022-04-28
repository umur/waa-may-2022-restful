package com.example.phase1.service.impl;

import com.example.phase1.domain.Student;
import com.example.phase1.repository.StudentRepository;
import com.example.phase1.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public void save(Student s) {

    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student getById(int id) {
        return null;
    }
}
