package com.example.lab1.service;


import com.example.lab1.domain.Course;
import com.example.lab1.dtos.CourseDTOV1;
import com.example.lab1.repository.CourseRepository;
import com.example.lab1.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    ModelMapper modelMapper;
    @Autowired
    StudentRepository studentRepository;

    public Course addCourse(Course course) {
        return courseRepository.addCourse(course);
    }

    public List<CourseDTOV1> getCourses() {
        Optional<List<Course>> courseList = Optional.ofNullable(courseRepository.getCourses());

        if (courseList.isPresent()) {
            return courseList.get().stream().map(c -> modelMapper.map(c, CourseDTOV1.class)).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public Optional<CourseDTOV1> getCourse(Long id) {
        return courseRepository.getCourse(id).map(c -> modelMapper.map(c, CourseDTOV1.class));
    }


    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }

    public void updateCourse(Long id, Course course) {
        courseRepository.updateCourse(id, course);
    }

    @Override
    public List<CourseDTOV1> getCourseByStudentId(long id) {
        return studentRepository.getStudent(id).getCoursesTaken().stream().map(c -> modelMapper.map(c, CourseDTOV1.class)).collect(Collectors.toList());
    }
}
