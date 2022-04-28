package com.example.lab1.repo;

import com.example.lab1.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {
    private static List<Course> courseList = new ArrayList<>(){{
        add(new Course(1, "WAP", "CS12"));
    }};

    public void save(Course course){
        courseList.add(course);
    }

    public void delete(int id) {
        Optional<Course> course = courseList.stream().filter(c -> c.getId() == id).findFirst();
        if (course.isPresent()) courseList.remove(course.get());
    }

    public void update(int id, Course courseUpdate) {
        var course = courseList.stream().filter(c -> c.getId() == id).findFirst();
        if (course.isPresent()){
            course.get().setName(courseUpdate.getName());
            course.get().setCode(courseUpdate.getCode());
        }
    }

    public List<Course> getAll() {
        return courseList;
    }

    public Course getById(int id) {
        return courseList.stream().filter(c -> c.getId() == id).findFirst().orElseGet(null);
    }


}
