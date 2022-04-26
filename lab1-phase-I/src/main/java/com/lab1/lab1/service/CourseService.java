package com.lab1.lab1.service;

import com.lab1.lab1.model.Course;

import java.util.List;

public interface CourseService {

    void save(Course c);
    void delete(int id);
    List<Course> getAll();
    Course getById(int id);

}
