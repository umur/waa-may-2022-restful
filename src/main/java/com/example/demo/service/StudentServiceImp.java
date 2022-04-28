package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

    private final StudentRepo sRepo;

    @Override
    public void save(StudentDto dto) {
        Student s= new Student();
        s.setId(dto.getId());
        s.setEmail(dto.getEmail());
        s.setFirstName(dto.getFirstName());
        s.setLastName(dto.getLastName());
        s.setMajor(dto.getMajor());
        sRepo.save(s);
    }

    @Override
    public void delete(int id) {
        sRepo.delete(id);
    }

    @Override
    public List<StudentDto> getAll() {
        var studentList=sRepo.getAll();
        var result= new ArrayList<StudentDto>();
        studentList.forEach(s->{
            StudentDto dto= new StudentDto();
            dto.setId(s.getId());
            dto.setEmail(s.getEmail());
            dto.setFirstName(s.getFirstName());
            dto.setLastName(s.getLastName());
            dto.setMajor(s.getMajor());
        });
        return result;
    }

    @Override
    public StudentDto getById(int id) {
        Student s= sRepo.getById(id);
        StudentDto dto= new StudentDto();
        dto.setId(s.getId());
        dto.setEmail(s.getEmail());
        dto.setFirstName(s.getFirstName());
        dto.setLastName(s.getLastName());
        dto.setMajor(s.getMajor());
        return dto;
    }

    @Override
    public void update(int id, StudentDto dto) {
        Student s= sRepo.getById(id);
        s.setId(dto.getId());
        s.setEmail(dto.getEmail());
        s.setFirstName(dto.getFirstName());
        s.setLastName(dto.getLastName());
        s.setMajor(dto.getMajor());
        sRepo.update(id,s);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var studentList=sRepo.getStudentsByMajor(major);
        var result= new ArrayList<StudentDto>();
        studentList.forEach(s->{
            StudentDto dto= new StudentDto();
            dto.setId(s.getId());
            dto.setEmail(s.getEmail());
            dto.setFirstName(s.getFirstName());
            dto.setLastName(s.getLastName());
            dto.setMajor(s.getMajor());
        });
        return result;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {
        var courseList=sRepo.getCoursesByStudentId(id);
        var result= new ArrayList<CourseDto>();
        courseList.forEach(c->{
            CourseDto dto= new CourseDto();
            dto.setCode(c.getCode());
            dto.setName(c.getName());
            dto.setId(c.getId());
        });
        return result;
    }
}
