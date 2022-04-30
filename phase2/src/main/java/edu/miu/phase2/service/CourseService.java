package edu.miu.phase2.service;

import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.entity.Course;

import java.util.List;

public interface CourseService {
    void save(CourseDto course);

    void update(CourseDto course, int id);

    void delete(int id);

    List<CourseDto> getAll();

    CourseDto getById(int id);
}
