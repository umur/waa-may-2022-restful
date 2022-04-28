package com.example.lab1.service.impl;

import com.example.lab1.dto.CourseDTO;
import com.example.lab1.dto.StudentDTO;
import com.example.lab1.entity.Student;
import com.example.lab1.repo.StudentRepo;
import com.example.lab1.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(StudentDTO s) {
        studentRepo.save(modelMapper.map(s, Student.class));
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public void update(int id, StudentDTO s) {
        studentRepo.update(id, modelMapper.map(s, Student.class));
    }

    @Override
    public List<StudentDTO> getAll() {
        return studentRepo.getAll().stream().map(s -> modelMapper.map(s, StudentDTO.class)).toList();
    }

    @Override
    public StudentDTO getById(int id) {
        return studentRepo.getById(id).isPresent() ? modelMapper.map(studentRepo.getById(id).get(), StudentDTO.class) : null;
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major).stream().map(s -> modelMapper.map(s, StudentDTO.class)).toList();
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId).stream().map(c -> modelMapper.map(c, CourseDTO.class)).toList();
    }
}
