package com.lab1.lab1.service.impl;

import com.lab1.lab1.dto.CourseDto;
import com.lab1.lab1.dto.StudentDto;
import com.lab1.lab1.model.Course;
import com.lab1.lab1.model.Student;
import com.lab1.lab1.repository.CourseRepo;
import com.lab1.lab1.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    @Override
    public void save(CourseDto c) {
        Course course = new Course();
        course.setId(c.getId());
        course.setName(c.getName());
        course.setCode(c.getCode());
        courseRepo.save(course);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public List<CourseDto> getAll() {
        List<CourseDto> result = new ArrayList<CourseDto>();
        List<Course> entityList = courseRepo.getAll();
        entityList.forEach(c->{
            //convert
            CourseDto dto = new CourseDto();
            dto.setId(c.getId());
            dto.setName(c.getName());
            dto.setCode(c.getCode());

            result.add(dto);
        });
        return result;
    }

    @Override
    public CourseDto getById(int id) {

        Course c = courseRepo.getById(id);
        CourseDto course = new CourseDto();
        course.setId(c.getId());
        course.setName(c.getName());
        course.setCode(c.getCode());

        return course;
    }
}
