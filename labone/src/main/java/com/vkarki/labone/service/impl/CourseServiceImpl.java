package com.vkarki.labone.service.impl;

import com.vkarki.labone.domain.Course;
import com.vkarki.labone.dto.SimpleCourseDto;
import com.vkarki.labone.repository.CourseRepo;
import com.vkarki.labone.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public void save(SimpleCourseDto course) {
        Course c = new Course();
        c.setName(course.getName());
        c.setCode(course.getCode());
        c.setId(course.getId());
        courseRepo.save(c);
    }

    @Override
    public void update(SimpleCourseDto course, int id) {
        Course c = new Course();
        c.setName(course.getName());
        c.setCode(course.getCode());
        c.setId(course.getId());
        courseRepo.update(c, id);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public List<SimpleCourseDto> getAll() {
        var courses = courseRepo.getAll();

        var result = new ArrayList<SimpleCourseDto>();

        courses.forEach(course-> {
            SimpleCourseDto c = new SimpleCourseDto();
            c.setName(course.getName());
            c.setCode(course.getCode());
            c.setId(course.getId());
            result.add(c);
        });

        return result;
    }

    @Override
    public SimpleCourseDto getById(int id) {
        var course = courseRepo.getById(id);
        SimpleCourseDto c = new SimpleCourseDto();
        c.setName(course.getName());
        c.setCode(course.getCode());
        c.setId(course.getId());
        return c;
    }
}
