package com.example.assignment1phase1.repository;

import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static ArrayList<Student> students;
   // private List<Student>l=new ArrayList<>();

    static {
        students = new ArrayList<>();
        Student s = new Student();
        s.setId(1);
        s.setFirstName("Abdelrahman");
        s.setLastName("Freek");
        s.setMajor("Compro");
        Course c = new Course();
        c.setId(1);
        c.setName("WAA");
        c.setCode("CS545");
        List<Course> courseList = new ArrayList<>();
        courseList.add(c);

        s.setCoursesTaken(courseList);
        s.setGpa("3.7");
        students.add(s);

    }

    public void save(Student s) {
        students.add(s);
       // l.add(s);

    }

    public List<Student> getAll() {
        return students;
    }

    public Student getById(int id) {
        return students.stream().filter(s -> s.getId() == id).collect(Collectors.toList()).get(0);
    }

    public void delete(int id) {
        System.out.println("id" + id);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id)
                students.remove(students.get(i));
        }
        //  students.stream().filter(s -> s.getId() == id).forEach(s -> students.remove(s));
    }

    public Student update(Student s, int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id)
                students.set(i, s);
        }
        return s;
    }

    public List<Student> getStudentsByMajor(String major) {
        System.out.println("hiiii");
        return students.stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList());
    }
    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream().filter(s -> s.getId() == studentId).collect(Collectors.toList()).get(0).getCoursesTaken();
    }

}
