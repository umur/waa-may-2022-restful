package com.waa.phase1.repository;

import com.waa.phase1.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();

    public List<Course> getAll() {
        return courses;
    }

    public void save(Course c) {
        var notExists = courses.stream()
                        .noneMatch(l -> l.getId() == c.getId());

        if (notExists) {
            courses.add(c);
        }
    }

    public void delete(Long id) {
        courses.stream()
                .filter(crs -> crs.getId() == id)
                .forEach(c -> courses.remove(c));
    }

    public Course getById(Long id) {
        return courses.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Long id, Course c) {
        Course course = getById(id);
        if (course != null) {
            course.setName(c.getName());
            course.setCode(c.getCode());
        }
    }
}
