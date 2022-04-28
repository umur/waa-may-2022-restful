package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> getAll();

    public boolean save(Student s);

    public List<Student> update(Student s, int id);

    public void delete(int id);

    public List<Student> getAllV2(String major);

    public List<Course> getCourseTaken(int id);
}