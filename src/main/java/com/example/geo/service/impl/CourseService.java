package com.example.geo.service.impl;

import com.example.geo.Utilities.ModelMapperUti;
import com.example.geo.domain.Course;
import com.example.geo.domain.dto.CourseDto;
import com.example.geo.repository.impl.CourseRepo;
import com.example.geo.service.ServiceInit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseService implements ServiceInit<CourseDto> {
    private final CourseRepo courseRepo;
    private final ModelMapperUti modelMapperUti;
    public List<CourseDto> getAll(){return modelMapperUti.mapList(courseRepo.getAll(), CourseDto.class);}
    public void save(CourseDto c){
        courseRepo.save(modelMapperUti.map(c,Course.class));}
    public void delete(int id){
        courseRepo.delete((id));}
    public void update(int id,CourseDto c) { courseRepo.update(id,modelMapperUti.map(c,Course.class));}
    public CourseDto getById(int id) {return modelMapperUti.map(courseRepo.getById(id),CourseDto.class);}
}

