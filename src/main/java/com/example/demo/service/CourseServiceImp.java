package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepo cRepo;
//
//    public CourseServiceImp(CourseRepo cRepo) {
//        this.cRepo = cRepo;
//    }

    @Override
    public void save(Course c) {
        cRepo.save(c);
    }

    @Override
    public void delete(int id) {
        cRepo.delete(id);
    }

    @Override
    public List<Course> getAll() {
        return cRepo.getAll();
    }

    @Override
    public Course getById(int id) {
        return cRepo.getById(id);
    }

    @Override
    public void update(int id, Course c) {
        cRepo.update(id,c);
    }
}
