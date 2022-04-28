package com.example.demo.service.impl;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public void save(Course s) {
        courseRepo.save(s);
    }

    @Override
    public List<Course> update(Course s,int id){
        return courseRepo.update(s,id);
    }

    @Override
    public void delete(int id){
        courseRepo.delete(id);
    }
}
