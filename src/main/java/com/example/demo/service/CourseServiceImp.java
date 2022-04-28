package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepo cRepo;
//
//    public CourseServiceImp(CourseRepo cRepo) {
//        this.cRepo = cRepo;
//    }

    @Override
    public void save(CourseDto dto) {
        Course c= new Course();
        c.setCode(dto.getCode());
        c.setName(dto.getName());
        c.setId(dto.getId());
        cRepo.save(c);
    }

    @Override
    public void delete(int id) {
        cRepo.delete(id);
    }

    @Override
    public List<CourseDto> getAll() {
        var courseList=cRepo.getAll();
        var result= new ArrayList<CourseDto>();
        courseList.forEach(c->{
            CourseDto dto= new CourseDto();
            dto.setCode(c.getCode());
            dto.setName(c.getName());
            dto.setId(c.getId());
        });
        return result;
    }

    @Override
    public CourseDto getById(int id) {
        Course c= cRepo.getById(id);
        CourseDto dto= new CourseDto();
        dto.setCode(c.getCode());
        dto.setName(c.getName());
        dto.setId(c.getId());
        return dto;
    }

    @Override
    public void update(int id, CourseDto c) {
        Course newCourse= new Course();
        newCourse.setCode(c.getCode());
        newCourse.setId(c.getId());
        newCourse.setName(c.getName());
        cRepo.update(id,newCourse);
    }
}
