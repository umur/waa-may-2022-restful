package com.example.geo.repository.impl;

import com.example.geo.domain.Course;
import com.example.geo.repository.RepoInit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class CourseRepo implements RepoInit<Course> {


    private static final ArrayList<Course> courses=new ArrayList<>();
    static  {

        for (int i = 0; i < 101; i++) {
            Course c=new Course(i, "name" + i, "code" + i);
            courses.add(c);
        }
    }
    public  List<Course> getAll(){return courses;}
    public void save(Course c){courses.add(c);}
    public void delete(int id){courses.removeIf(c->c.getId()==id);}
    public void update(int id,Course c) {
        int index = courses.indexOf(getById(c.getId()));
        c.setId(id);
         courses.set(index, c);
    }
    public Course getById(int id) {
        return courses.stream().filter(cc -> cc.getId() == id).findFirst().orElse(null);    }
 }
