package com.example.assignment1phase1.repository;

import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CourseRepo {
    private static ArrayList<Course> courses;

    static {
        courses = new ArrayList<>();
        Course c = new Course();
        c.setId(1);
        c.setName("WAA");
        c.setCode("CS545");
        courses.add(c);
    }

    public void save(Course c) {
        courses.add(c);
    }

    public List<Course> getAll() {
        return courses;
    }

    public Course getById(int id) {
        return courses.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
    }

    public void delete(int id) {

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id)
                courses.remove(courses.get(i));
        }

    }

    public Course update(Course c, int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id)
                courses.set(i, c);
        }
        return c;
    }

}
