package com.example.assignment1phase1.service;

import com.example.assignment1phase1.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course getById(int id );
    void delete(int id);
    Course  update(Course c,int id);
    void save(Course c);
}
