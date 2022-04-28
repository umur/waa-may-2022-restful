package com.example.lab1.service;

import com.example.lab1.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course c);
    void delete(int id);
    void update(int id, Course courseUpdate);
    List<Course> getAll();
    Course getById(int id);
}
