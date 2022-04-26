package com.waa.phase1.service.Impl;

import com.waa.phase1.domain.Course;
import com.waa.phase1.repository.CourseRepository;
import com.waa.phase1.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void save(Course c) {
        courseRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public Course getById(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public void update(Long id, Course c) {
        courseRepository.update(id, c);
    }
}
