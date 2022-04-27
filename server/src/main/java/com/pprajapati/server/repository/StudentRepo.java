package com.pprajapati.server.repository;

import com.pprajapati.server.domain.Course;
import com.pprajapati.server.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>() {
        {
            add(new Student(1, "Puru", "Prajapati", "pprajapati@miu.edu", "CS", 'A', List.of(new Course[]{
                    new Course(1, "WAA", "CS5"),
                    new Course(2, "WAP", "CS4"),
                    new Course(3, "MPP", "CS3")
            })));
            add(new Student(2, "Test", "Test", "ttest@miu.edu", "MSD", 'B', List.of(new Course[]{
                    new Course(1, "WAA", "CS5"),
                    new Course(2, "WAP", "CS4"),
                    new Course(3, "MPP", "CS3"),
                    new Course(4, "FPP", "CS2")
            })));
        }
    };

    public static List<Student> getStudents() {
        return students;
    }

    public void save(Student s) {
        if (students.stream()
                .noneMatch(st -> st.getId() == s.getId())) {
            students.add(s);
        }
    }

    public void delete(int id) {
        students = students.stream()
                .filter(student -> student.getId() != id)
                .collect(Collectors.toList());
//        students.stream()
//                .filter(student -> student.getId() == id)
//                .forEach(s->students.remove(s));
    }

    public void update(int id, Student s) {
        students = students.stream()
                .filter(student -> student.getId() != id)
                .collect(Collectors.toList());
        students.add(s);
    }

    public Student getById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor() == major)
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .map(student -> student.getCoursesTaken())
                .flatMap(c -> c.stream())
                .collect(Collectors.toList());
    }


}
