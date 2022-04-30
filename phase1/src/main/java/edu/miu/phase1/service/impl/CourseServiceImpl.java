package edu.miu.phase1.service.impl;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.repository.CourseRepository;
import edu.miu.phase1.service.CourseService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public void save(Course course) {
        courseRepository.save(course);

    }

    @Override
    public void update(Course course, int id) {
        courseRepository.update(course, id);
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(int id) {
        return courseRepository.findById(id);
    }
}
