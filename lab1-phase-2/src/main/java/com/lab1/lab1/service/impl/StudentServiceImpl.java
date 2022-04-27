package com.lab1.lab1.service.impl;

import com.lab1.lab1.dto.CourseDto;
import com.lab1.lab1.dto.StudentDto;
import com.lab1.lab1.model.Course;
import com.lab1.lab1.model.Student;
import com.lab1.lab1.repository.StudentRepo;
import com.lab1.lab1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public void save(StudentDto s) {
        Student s1 = new Student();
        s1.setId(s.getId());
        s1.setFirstName(s.getFirstName());
        s1.setLastName(s.getLastName());
        s1.setEmail(s.getEmail());
        s1.setMajor(s.getMajor());
        s1.setCoursesTaken(s.getCoursesTaken());
        studentRepo.save(s1);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<StudentDto> getAll() {
        var result = new ArrayList<StudentDto>();
        var entityList = studentRepo.getAll();
        entityList.forEach(s->{
            //convert
            StudentDto dto = new StudentDto();
            dto.setId(s.getId());
            dto.setFirstName(s.getFirstName());
            dto.setLastName(s.getLastName());
            dto.setEmail(s.getEmail());
            dto.setMajor(s.getMajor());
            dto.setCoursesTaken(s.getCoursesTaken());
            result.add(dto);
        });
        return result;
    }

    @Override
    public StudentDto getById(int id) {
        Student s = studentRepo.getById(id);
        StudentDto studentDto = new StudentDto();
        studentDto.setId(s.getId());
        studentDto.setFirstName(s.getFirstName());
        studentDto.setLastName(s.getLastName());
        studentDto.setEmail(s.getEmail());
        studentDto.setMajor(s.getMajor());
        studentDto.setCoursesTaken(s.getCoursesTaken());
        return studentDto;
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var result = new ArrayList<StudentDto>();
        var entityList = studentRepo.getStudentsByMajor(major);
        entityList.forEach(s->{
            //convert
            StudentDto dto = new StudentDto();
            dto.setId(s.getId());
            dto.setFirstName(s.getFirstName());
            dto.setLastName(s.getLastName());
            dto.setEmail(s.getEmail());
            dto.setMajor(s.getMajor());
            dto.setCoursesTaken(s.getCoursesTaken());
            result.add(dto);
        });
        return result;
    }

    @Override
    public  List<CourseDto> getCoursesByStudentId(int id) {
        var result = new ArrayList<CourseDto>();
        List<Course> entityList = studentRepo.getCoursesByStudentId(id);
        entityList.forEach(c->{
            //convert
            CourseDto dto = new CourseDto();
            dto.setId(c.getId());
            dto.setName(c.getName());
            dto.setCode(c.getCode());
            result.add(dto);
        });
        return result;
    }
}
