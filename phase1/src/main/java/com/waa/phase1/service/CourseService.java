package com.waa.phase1.service;

import com.waa.phase1.domain.Course;

import java.util.List;

public interface CourseService {
    void save(Course c);

    void delete(Long id);

    List<Course> getAll();

    Course getById(Long id);

    void update(Long id, Course c);
}
