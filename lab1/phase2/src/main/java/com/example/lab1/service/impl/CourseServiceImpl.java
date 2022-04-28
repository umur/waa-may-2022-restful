package com.example.lab1.service.impl;

import com.example.lab1.dto.CourseDTO;
import com.example.lab1.entity.Course;
import com.example.lab1.repo.CourseRepo;
import com.example.lab1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public void save(CourseDTO c) {
        Course course = new Course(c.getId(), c.getName(), c.getCode());
        courseRepo.save(course);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public void update(int id, CourseDTO c) {
        Course course = new Course(c.getId(), c.getName(), c.getCode());
        courseRepo.update(id, course);
    }

    @Override
    public List<CourseDTO> getAll() {
        return courseRepo.getAll().stream().map(c -> new CourseDTO(c.getId(), c.getName(), c.getCode())).toList();
    }

    @Override
    public CourseDTO getById(int id) {
        Course c = courseRepo.getById(id);
        return new CourseDTO(c.getId(), c.getName(), c.getCode());
    }


}
