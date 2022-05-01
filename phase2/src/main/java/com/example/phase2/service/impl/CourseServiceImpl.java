package com.example.phase2.service.impl;

import com.example.phase2.domain.Course;
import com.example.phase2.dto.CourseDto;
import com.example.phase2.repository.CourseRepo;
import com.example.phase2.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    private CourseServiceImpl(CourseRepo courseRepo){
        this.courseRepo=courseRepo;
    }
    @Override
    public List<CourseDto> getAll() {

        var entityList= courseRepo.getAll();

        var result = new ArrayList<CourseDto>();

        entityList.forEach(c->{
            CourseDto cDto = new CourseDto();
            cDto.setName(c.getName());
            cDto.setCode(c.getCode());
            result.add(cDto);
        });

        return  result;
    }

    @Override
    public void save(CourseDto c) {

        Random rand = new Random();

        Course course = new Course();

        course.setId(rand.nextInt());
        course.setName(c.getName());
        course.setCode(c.getCode());

        courseRepo.save(course);
    }
}
