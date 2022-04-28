package com.lab.restapi.repository;

import com.lab.restapi.entity.Course;
import com.lab.restapi.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {



/*
    private static List<Course> courses = new ArrayList<>();

    static {
        Course c1 = new Course();
        c1.setId(1l);
        c1.setCode("CS472");
        c1.setName("Web Programming");

        Course c2 = new Course();
        c2.setId(2l);
        c2.setCode("CS545");
        c2.setName("Web Application Architecture");

        Course c3 = new Course();
        c3.setId(3l);
        c3.setCode("CS525");
        c3.setName("Advanced Software Development");

        Course c4 = new Course();
        c4.setId(4l);
        c4.setCode("CS544");
        c4.setName("Enterprise Architecture");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

    }

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> getAll() {
        return courses;
    }

    public Course getById(long id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    public void delete(long id) {
        courses.stream().filter(c -> c.getId() == id).forEach(c -> courses.remove(c));
    }


    */
}
