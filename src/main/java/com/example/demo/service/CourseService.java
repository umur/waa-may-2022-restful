package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public List<Course> getAll();

    public void save(CourseDto s);

    public List<Course> update(CourseDto s, int id);

    public void delete(int id);

    public Course courseFromCourseDto(CourseDto cou);
}
