package com.example.lab1.repository;


import com.example.lab1.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    Map<Long, Course> courses = new HashMap<>();


    public Course addCourse(Course course) {
        return courses.put(course.getId(), course);
    }

    public List<Course> getCourses() {
       return courses.values().stream().collect(Collectors.toList());
    }

    public Optional<Course> getCourse(Long id) {
        return courses.values().stream().filter(c -> c.getId() == id).findFirst();
    }

    public void deleteCourse(Long id) {
        courses.values().removeIf(c -> c.getId() == id);
    }

    public void updateCourse(Long id, Course course) {
        courses.remove(id);
        courses.put(id, course);
    }

}
