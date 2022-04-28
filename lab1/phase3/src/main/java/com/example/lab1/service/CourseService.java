package com.example.lab1.service;


import com.example.lab1.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    void save(CourseDTO c);
    void delete(int id);
    void update(int id, CourseDTO courseUpdate);
    List<CourseDTO> getAll();
    CourseDTO getById(int id);
}
