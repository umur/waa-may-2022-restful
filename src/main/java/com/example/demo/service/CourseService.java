package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {
    void save(CourseDto c);

    void delete(int id);

    List<CourseDto> getAll();

    CourseDto getById(int id);
    void update(int id, CourseDto c);
}
