package com.lab.restapi.service.impl;

import com.lab.restapi.dto.CourseDto;
import com.lab.restapi.entity.Course;
import com.lab.restapi.repository.CourseRepository;
import com.lab.restapi.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(CourseDto course) {
        Course c = new Course();
        c.setId(course.getId());
        c.setName(course.getName());


        courseRepository.save(c);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<CourseDto> getAll() {

        //var entityList = courseRepository.getAll();
        var entityList = courseRepository.findAll();

        var result = new ArrayList<CourseDto>();

        entityList.forEach(c -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(c.getId());
            courseDto.setName(c.getName());

            result.add(courseDto);
        });
        return result;
    }

    @Override
    public Course getById(long id) {
        //return courseRepository.getById(id);
        return courseRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        //courseRepository.delete(id);
        courseRepository.deleteById(id);
    }
}
