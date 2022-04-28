package com.lab.Restful.service.impl;

import com.lab.Restful.dto.CourseDto;
import com.lab.Restful.entity.Course;
import com.lab.Restful.repo.CourseRepo;
import com.lab.Restful.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;//final not static

    @Override
    public void save(Course c) {
        Course cr=new Course();
        cr.setId(c.getId());
        cr.setName(c.getName());
        cr.setCode(c.getCode());
        courseRepo.save(cr);
    }

    @Override
    public void update(Course c, int id) {
        List<Course> courseList= courseRepo.findAllById(id);
        for(Course cr : courseList){
            //cr.setId(c.getId());
            cr.setName(c.getName());
            cr.setCode(c.getCode());
        }
        courseRepo.saveAll(courseList);
    }

    @Override
    public void delete(int id) {
        courseRepo.deleteById(id);
    }

    @Override
    public List<CourseDto> getAll() {

        var entityList=  courseRepo.findAll();

        var result = new ArrayList<CourseDto>();
        for(Course c: entityList){
            CourseDto dto = new CourseDto();
            dto.setCode(c.getCode());
            dto.setName(c.getName());
            result.add(dto);
        }
        return result;
        //return courseRepo.findAll();
    }

    @Override
    public CourseDto getById(int id) {

        Course c = courseRepo.findAllById(id).get(0);
        CourseDto dto = new CourseDto();
        dto.setCode(c.getCode());
        dto.setName(c.getName());
        return dto;
    }
    @Override
    public Course getCourseById(int id) {

        return courseRepo.findAllById(id).get(0);

    }


}
