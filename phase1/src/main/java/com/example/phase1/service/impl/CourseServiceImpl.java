package com.example.phase1.service.impl;

import com.example.phase1.domain.Course;
import com.example.phase1.repository.CourseRepo;
import com.example.phase1.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    private CourseServiceImpl(CourseRepo courseRepo){
        this.courseRepo=courseRepo;
    }
    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public void save(Course c) {
        courseRepo.save(c);
    }

    @Override
    public void delete(int id){
        courseRepo.delete(id);
    }

    @Override
    public  void  update(Course c, int id){
        courseRepo.update(c, id);
    }
}
