package com.example.phase1.service;

import com.example.phase1.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAll();

    void save(Course c);

    void delete(int id);

    void update(Course c, int id);
}
