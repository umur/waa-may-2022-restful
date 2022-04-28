package com.example.assignment1phase1.service.impl;

import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.repository.CourseRepo;
import com.example.assignment1phase1.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public Course getById(int id) {
        return courseRepo.getById(id);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public Course update(Course c, int id) {
        return courseRepo.update(c, id);
    }

    @Override
    public void save(Course c) {
        courseRepo.save(c);
    }
}
