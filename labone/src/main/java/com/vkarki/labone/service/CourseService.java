package com.vkarki.labone.service;

import com.vkarki.labone.domain.Course;
import com.vkarki.labone.dto.SimpleCourseDto;

import java.util.List;

public interface CourseService {
    void save(SimpleCourseDto course);

    void update(SimpleCourseDto course, int id);

    void delete(int id);

    List<SimpleCourseDto> getAll();

    SimpleCourseDto getById(int id);
}
