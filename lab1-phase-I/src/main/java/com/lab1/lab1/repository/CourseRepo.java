package com.lab1.lab1.repository;

import com.lab1.lab1.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    private static List<Course> courses;
    static  {
        courses = new ArrayList<>();
        var c = new Course();
        c.setId(1);
        c.setName("Web Application Architecture");
        c.setCode("CS545");
        courses.add(c);
    }
    public List<Course> getAll() {
        return courses;
    }

    public void delete(int id) {
        courses.stream().filter(c -> c.getId() == id).forEach( c -> courses.remove(c));
    }
    public Course getById(int id) {
        return courses.stream()
                .filter( c -> c.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void save(Course c) {
        var checkIfCourseExists = courses
                .stream()
                .noneMatch(l -> l.getId() == c.getId());
        if(checkIfCourseExists){
            courses.add(c);
        }
    }
}
