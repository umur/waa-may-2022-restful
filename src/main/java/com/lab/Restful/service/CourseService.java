package com.lab.Restful.service;

import com.lab.Restful.dto.CourseDto;
import com.lab.Restful.entity.Course;

import java.util.List;

public interface CourseService {
        void save(Course c);
        void update(Course c, int id);
        void delete(int id);
        List<CourseDto> getAll();
        CourseDto getById(int id);
        Course getCourseById(int id);

}
