package com.lab.restapi.service;

import com.lab.restapi.dto.CourseDto;
import com.lab.restapi.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    void save(CourseDto course);

    void save(Course course);

    List<CourseDto> getAll();

    Course getById(long id);

    void delete(long id);
}
