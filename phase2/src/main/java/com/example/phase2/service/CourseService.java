package com.example.phase2.service;

import com.example.phase2.domain.Course;
import com.example.phase2.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> getAll();

    void save(CourseDto c);
}
