package com.example.geo.service.impl;

import com.example.geo.domain.Course;
import com.example.geo.repository.impl.CourseRepo;
import com.example.geo.service.ServiceInit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseService implements ServiceInit<Course> {
    private final CourseRepo courseRepo;
    public List<Course> getAll(){return courseRepo.getAll();}
    public void save(Course c){
        courseRepo.save(c);}
    public void delete(int id){
        courseRepo.delete((id));}
    public void update(int id,Course c) { courseRepo.update(id,c);}
    public Course getById(int id) {return courseRepo.getById(id);}
}

