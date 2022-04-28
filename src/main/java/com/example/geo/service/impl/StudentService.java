package com.example.geo.service.impl;

import com.example.geo.Utilities.ModelMapperUti;
import com.example.geo.domain.Course;
import com.example.geo.domain.Student;
import com.example.geo.domain.dto.CourseDto;
import com.example.geo.domain.dto.StudentDto;
import com.example.geo.repository.impl.CourseRepo;
import com.example.geo.repository.impl.StudentRepo;
import com.example.geo.service.ServiceInit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements ServiceInit<StudentDto> {
    private final StudentRepo studentRepo;
    private final ModelMapperUti modelMapperUti;
    public List<StudentDto> getAll() {
        return modelMapperUti.mapList( studentRepo.getAll(),StudentDto.class);
    }

    public void save(StudentDto c) {
        studentRepo.save(modelMapperUti.map(c,Student.class));
    }

    public void delete(int id) {
        studentRepo.delete((id));
    }

    public void update(int id, StudentDto c) {
         studentRepo.update(id, modelMapperUti.map(c,Student.class));
    }

    public StudentDto getById(int id) {
        return modelMapperUti.map( studentRepo.getById(id),StudentDto.class);
    }
    public List<StudentDto> getStudentsByMajor(String major) {
        return modelMapperUti.mapList(studentRepo.getStudentsByMajor(major),StudentDto.class);
    }
    public List<CourseDto> getCoursesByStudentId(int studentId){
        return modelMapperUti.mapList(studentRepo.getCoursesByStudentId(studentId),CourseDto.class);
    }
}

