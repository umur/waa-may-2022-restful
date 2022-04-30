package edu.miu.phase1.repository;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();

    static {

        Course course1 = new Course(1,"Calculus","Cal101");
        Course course2 = new Course(2,"Biology","Bio101");
        Course course3 = new Course(3,"Chemistry","Chem101");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }

    public void save(Course course) {
        courses.add(course);
    }

    public void update(Course course, int id) {
        var isExist = courses.stream().filter(s -> s.getId() == id)
                .findFirst();
        if(isExist.isPresent()) {
            courses.remove(isExist.get());
            courses.add(course);
        }
    }

    public void delete(int id) {
        var isExist = courses.stream().filter(s -> s.getId() == id)
                .findFirst();
        if(isExist.isPresent()) {
            courses.remove(isExist.get());
        }
    }

    public List<Course> findAll(){
        return courses;
    }

    public Course findById(int id){
        return courses.stream().filter(c -> c.getId() == id).findFirst().get();
    }
}
