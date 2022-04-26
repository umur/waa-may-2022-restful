package com.example.demo.service;

import com.example.demo.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> getAll();

    public boolean save(Student p);
}