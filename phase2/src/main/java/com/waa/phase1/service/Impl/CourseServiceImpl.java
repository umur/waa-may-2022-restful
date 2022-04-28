package com.waa.phase1.service.Impl;

import com.waa.phase1.domain.Course;
import com.waa.phase1.dto.CourseDto;
import com.waa.phase1.repository.CourseRepository;
import com.waa.phase1.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void save(CourseDto c) {
        courseRepository.save(c.toCourse());
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(id);
    }

    @Override
    public List<CourseDto> getAll() {
        var courses = courseRepository.getAll();
        return courses.stream()
                .filter(Objects::nonNull)
                .map(CourseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getById(Long id) {
        var c = courseRepository.getById(id);
        if (c == null) return null;
        return new CourseDto(c);
    }

    @Override
    public void update(Long id, CourseDto c) {
        courseRepository.update(id, c.toCourse());
    }
}
