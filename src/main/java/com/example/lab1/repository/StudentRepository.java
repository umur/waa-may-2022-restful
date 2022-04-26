package com.example.lab1.repository;

import com.example.lab1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    Map<Long, Student> students = new HashMap<>();

    public Collection<Student> getStudents() {
        return students.values();
    }

    public Student getStudent(long id) {
        return students.get(id);
    }

    public Student createStudent(Student student) {
        students.put(student.getId(), student);
        return students.get(student.getId());
    }

    public void modifyStudent(long id, Student student) {
        students.remove(id);
        students.put(student.getId(), student);
    }

    public void deleteStudent(long id) {
        students.remove(id);
    }

    public Collection<Student> getStudentsByMajor(String major) {
        return students
                .values()
                .stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
    }
}
