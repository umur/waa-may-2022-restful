package com.waa.phase1.repository;

import com.waa.phase1.domain.Course;
import com.waa.phase1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public void save(Student s) {
        var notExists = students.stream()
                        .filter(l -> l.getId() == s.getId())
                                .noneMatch(l -> l.getId() == s.getId());
        if (notExists) {
            students.add(s);
        }
    }

    public void delete(Long id) {
        students.stream()
                .filter(student -> student.getId() == id)
                .forEach(l -> students.remove(l));
    }

    public Student getById(Long id) {
        return students.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Long id, Student s) {
        Student student = getById(id);
        if (student != null) {
            student.setEmail(s.getEmail());
            student.setFirstName(s.getFirstName());
            student.setLastName(s.getLastName());
            student.setMajor(s.getMajor());
            student.setCoursesTaken(s.getCoursesTaken());
        }
    }

    public List<Student> getByMajor(String major) {
        return students.stream()
                .filter(l -> l.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return students.stream()
                .filter(l -> l.getId() == studentId)
                .findFirst()
                .map(s -> s.getCoursesTaken())
                .orElse(Collections.emptyList());
    }

    public void addCourse(Long id, Course c) {
        var student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        if (student != null) {
            student.getCoursesTaken().add(c);
        }
    }
}
