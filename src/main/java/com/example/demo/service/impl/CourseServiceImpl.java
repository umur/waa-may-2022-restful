package com.example.demo.service.impl;

import com.example.demo.domain.Course;
import com.example.demo.dto.CourseDto;
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
    public void save(CourseDto c) {
        Course cou = courseFromCourseDto(c);
        courseRepo.save(cou);
    }

    @Override
    public List<Course> update(CourseDto c, int id){
        Course cou = courseFromCourseDto(c);
        return courseRepo.update(cou,id);
    }

    @Override
    public void delete(int id){
        courseRepo.delete(id);
    }

    @Override
    public Course courseFromCourseDto(CourseDto cou) {
        Course c = new Course();
        c.setId(cou.getId());
        c.setCode(cou.getCode());
        c.setName(cou.getName());
        return c;
    }
}
