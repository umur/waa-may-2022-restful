package com.example.phase2.service.impl;

import com.example.phase2.dto.CourseDto;
import com.example.phase2.dto.StudentDto;
import com.example.phase2.dto.StudentGpaDto;
import com.example.phase2.entity.Student;
import com.example.phase2.repo.StudentRepository;
import com.example.phase2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public List<StudentGpaDto> getAll2() {
        return studentRepository.getAll2();
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }

    @Override
    public List<StudentGpaDto> getStudentByMajor(String major) {
        return studentRepository.getStudentByMajor(major);
    }


    @Override
    public void save(StudentDto s) {
        studentRepository.save(s);
    }

    @Override
    public void save2(StudentGpaDto s) {
        studentRepository.save2(s);
    }

    @Override
    public void update(StudentDto s, int id) {
        studentRepository.update(s, id);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public StudentDto getById(int id) {
        return null;
    }
}
