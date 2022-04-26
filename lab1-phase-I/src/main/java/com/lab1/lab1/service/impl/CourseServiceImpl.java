package com.lab1.lab1.service.impl;

import com.lab1.lab1.model.Course;
import com.lab1.lab1.repository.CourseRepo;
import com.lab1.lab1.service.CourseService;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    @Override
    public void save(Course c) {
        courseRepo.save(c);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public Course getById(int id) {
        return courseRepo.getById(id);
    }
}
