package com.example.demo.repository;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static ArrayList<Course> courses = new ArrayList<>();

    public List<Course> getAll() {
        return courses;
    }

    public void save(Course c) {
        courses.add(c);
    }

    public List<Course> update(Course c,int id) {
        courses = new ArrayList<Course>(courses.stream().map(item->{
            if(item.getId()==id){
                return c;
            }
            return item;
        }).collect(Collectors.toList()));
        List<Course> updated = courses.stream().filter(item->item.getId()==id).collect(Collectors.toList());
        return updated;
    }

    public void delete(int id){
        courses =  new ArrayList<Course>(courses.stream().filter(item->item.getId()!=id).collect(Collectors.toList()));
    }
}
