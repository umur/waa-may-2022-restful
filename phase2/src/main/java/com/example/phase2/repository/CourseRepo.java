package com.example.phase2.repository;

import com.example.phase2.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private  static ArrayList<Course> courses=new ArrayList<>();

    public List<Course> getAll(){
        return courses;
    }

    public  void  save(Course c){
        courses.add(c);
    }
}
