package com.example.phase1.repository;

import com.example.phase1.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Repository
public class CourseRepo {
    private  static ArrayList<Course> courses=new ArrayList<>();

    public List<Course> getAll(){
        return courses;
    }

    public  void  save(Course c){
        courses.add(c);
    }

    public  void delete (int id){
        courses.stream()
                .filter(c->c.getId()==id)
                .forEach(c->courses.remove(c));
    }

    public void update(Course course, int id){
        var mayBecourse =
                courses.stream()
                        .filter(c->c.getId()==id)
                        .findAny();

        if(mayBecourse.isPresent()){

            courses.remove(mayBecourse.get());

            course.setId(id);
            courses.add(course);

        }
    }
}
