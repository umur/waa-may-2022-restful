package com.vkarki.labone.repository;

import com.vkarki.labone.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses;
    static {
        courses = new ArrayList<>();
        Course course1 = new Course();
        course1.setName("ML");
        course1.setCode("243");
        course1.setId(2);

        Course course2 = new Course();
        course2.setName("Data Science");
        course2.setCode("555");
        course2.setId(3);

        courses.add(course1);
        courses.add(course2);
    }

    public void save(Course course) {
        var notExists = courses.stream().noneMatch(c->c.getId()==course.getId());
        if(notExists)
            courses.add(course);
    }

    public void delete(int id) {
        courses.stream()
                .filter(c->c.getId() == id)
                .forEach(c->c.setDeleted(true));
    }

    public Course getById(int id) {
        return courses.stream()
                .filter(s->s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Course course, int id) {
        courses.stream()
                .filter(s->s.getId() == id)
                .forEach(item -> {
                    item.setName(course.getName());
                    item.setCode(course.getCode());
                });

    }

    public List<Course> getAll() {
        return courses.stream()
                .filter(s->!s.isDeleted())
                .collect(Collectors.toList());
    }

}
