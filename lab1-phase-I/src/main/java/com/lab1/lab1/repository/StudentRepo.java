package com.lab1.lab1.repository;

import com.lab1.lab1.model.Course;
import com.lab1.lab1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students;
    @Autowired
    private static CourseRepo courseRepo;

    static {
        students =  new ArrayList<>();
        var s = new Student();
        s.setId(1);
        s.setFirstName("Meresa");
        s.setLastName("Gebrewahd");
        s.setEmail("meresa27@gmail.com");
        s.setMajor("Compro");
        s.setCoursesTaken(courseRepo.getAll());
    }

    public void save(Student s) {
        var checkIfExists = students
                .stream()
                .noneMatch(l -> l.getId()==s.getId());
        if(checkIfExists) {
            students.add(s);
        }
    }

    public void delete(int id) {
        students.stream()
                .filter( l-> l.getId() == id)
                .forEach( l ->students.remove(l));
    }

    public Student getById(int id) {
        return students.stream()
                .filter( l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Student> getAll() {
        return students;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter( s -> s.getMajor() == major)
                .collect(Collectors.toList());
    }
}
