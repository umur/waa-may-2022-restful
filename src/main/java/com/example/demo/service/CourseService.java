package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course c);

    void delete(int id);

    List<Course> getAll();

    Course getById(int id);
    void update(int id, Course c);
}
