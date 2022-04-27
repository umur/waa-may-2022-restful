package com.lab1.lab1.service;

import com.lab1.lab1.dto.CourseDto;

import java.util.List;


public interface CourseService {

    void save(CourseDto c);
    void delete(int id);
    List<CourseDto> getAll();
    CourseDto getById(int id);

}
