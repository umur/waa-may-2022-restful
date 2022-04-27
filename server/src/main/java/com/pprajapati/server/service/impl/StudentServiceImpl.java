package com.pprajapati.server.service.impl;

import com.pprajapati.server.domain.Course;
import com.pprajapati.server.dto.CourseDto;
import com.pprajapati.server.dto.StudentDto;
import org.modelmapper.ModelMapper;
import com.pprajapati.server.domain.Student;
import com.pprajapati.server.repository.StudentRepo;
import com.pprajapati.server.service.StudentService;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper) {

        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(StudentDto s) {

        studentRepo.save(convertDtoToStudentEntity(s));
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepo.getStudents().stream()
                .map(this::convertStudentEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(int id) {
        return convertStudentEntityToDto(studentRepo.getById(id));
    }

    @Override
    public void update(int id, StudentDto s) {
        studentRepo.update(id, convertDtoToStudentEntity(s));
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major).stream()
                .map(this::convertStudentEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id).stream()
                .map(this::convertCourseEntityToDto)
                .collect(Collectors.toList());
    }

    private StudentDto convertStudentEntityToDto(Student student) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        StudentDto studentDto = new StudentDto();
        studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    private Student convertDtoToStudentEntity(StudentDto studentDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Student s = new Student();
        s = modelMapper.map(studentDto, Student.class);
        return s;
    }

    private CourseDto convertCourseEntityToDto(Course course) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        CourseDto courseDto = new CourseDto();
        courseDto = modelMapper.map(course, CourseDto.class);
        return courseDto;
    }

    private Course convertDtoToCourseEntity(CourseDto courseDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Course s = new Course();
        s = modelMapper.map(courseDto, Course.class);
        return s;
    }
}
