package com.example.lab1.service.impl;

import com.example.lab1.dto.CourseDTO;
import com.example.lab1.entity.Course;
import com.example.lab1.repo.CourseRepo;
import com.example.lab1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public void save(CourseDTO c) {
        courseRepo.save(modelMapper.map(c, Course.class));
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public void update(int id, CourseDTO c) {
        courseRepo.update(id, modelMapper.map(c, Course.class));
    }

    @Override
    public List<CourseDTO> getAll() {
        return courseRepo.getAll().stream().map(c -> modelMapper.map(c, CourseDTO.class)).toList();
    }

    @Override
    public CourseDTO getById(int id) {
        return modelMapper.map(courseRepo.getById(id), CourseDTO.class);
    }


}
