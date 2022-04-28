package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public List<Course> getAll();

    public void save(Course s);

    public List<Course> update(Course s, int id);

    public void delete(int id);
}
