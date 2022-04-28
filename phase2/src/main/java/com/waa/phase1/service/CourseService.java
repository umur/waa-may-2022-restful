package com.waa.phase1.service;

import com.waa.phase1.domain.Course;
import com.waa.phase1.dto.CourseDto;

import java.util.List;

public interface CourseService {
    void save(CourseDto c);

    void delete(Long id);

    List<CourseDto> getAll();

    CourseDto getById(Long id);

    void update(Long id, CourseDto c);
}
