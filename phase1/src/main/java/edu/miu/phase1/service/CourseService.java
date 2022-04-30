package edu.miu.phase1.service;

import edu.miu.phase1.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);

    void update(Course course, int id);

    void delete(int id);

    List<Course> getAll();

    Course getById(int id);
}
