package com.example.demo.repo;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private  List<Course> courses=new ArrayList<>();


    public void save(Course c){
        if(courses.stream().noneMatch(obj->obj.getId()==c.getId())){
            courses.add(c);
        }
    }
    public void update(int id, Course c){
        if(courses.stream().anyMatch(obj->obj.getId()==id)){
            delete(id);
            save(c);
        }
    }
    public void delete(int id) {
        Course obj = courses
                .stream()
                .filter(c -> c.getId() == id).findFirst().orElse(null);
        courses.remove(obj);
    }

    public Course getById(int id) {
        return courses
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Course> getAll(){
        return  courses;
}

}
