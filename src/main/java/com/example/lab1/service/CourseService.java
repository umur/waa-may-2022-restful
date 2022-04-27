package com.example.lab1.service;

import com.example.lab1.domain.Course;
import com.example.lab1.dtos.CourseDTOV1;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    public Course addCourse(Course course);

    public List<CourseDTOV1> getCourses();

    public Optional<CourseDTOV1> getCourse(Long id);

    public void deleteCourse(Long id);

    public void updateCourse(Long id, Course course) ;

    List<CourseDTOV1> getCourseByStudentId(long id);
}
