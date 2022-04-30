package edu.miu.phase2.service.impl;

import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.entity.Course;
import edu.miu.phase2.repository.CourseRepository;
import edu.miu.phase2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public void save(CourseDto course) {
        courseRepository.save(new Course(course.getId(), course.getName(), course.getCode()));

    }

    @Override
    public void update(CourseDto course, int id) {
        courseRepository.update(new Course(course.getId(), course.getName(), course.getCode()), id);
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }

    @Override
    public List<CourseDto> getAll() {
        List<Course> courses = courseRepository.findAll();
        return  courses.stream()
                .map(c -> new CourseDto(c.getId(), c.getName(), c.getCode()))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getById(int id) {
        Course course = courseRepository.findById(id);
        return new CourseDto(course.getId(), course.getName(), course.getCode());
    }

}
