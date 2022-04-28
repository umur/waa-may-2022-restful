package com.example.lab1.service.impl;

import com.example.lab1.entity.Course;
import com.example.lab1.repo.CourseRepo;
import com.example.lab1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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
    public void update(int id, Course courseUpdate) {
        courseRepo.update(id, courseUpdate);
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
