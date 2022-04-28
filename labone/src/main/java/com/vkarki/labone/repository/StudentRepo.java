package com.vkarki.labone.repository;

import com.vkarki.labone.domain.Course;
import com.vkarki.labone.domain.Student;
import com.vkarki.labone.dto.SimpleStudentDtoV2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students;
    static {
        students = new ArrayList<>();
        var s = new Student();
        Course course1 = new Course();

        course1.setId(1);
        course1.setCode("C435");
        course1.setName("Algorithms");

        Course course2 = new Course();
        course2.setId(2);
        course2.setCode("C545");
        course2.setName("WAA");

        s.setId(1);
        s.setFirstName("John");
        s.setMajor("CS");
        s.setLastName("Doe");
        s.setGpa(4.00);
        s.addCourse(course1);
        s.addCourse(course2);
        s.setEmail("john.doe@email.com");

        students.add(s);
    }

    public void save(Student student) {
        var notExists =students.stream().noneMatch(s->s.getId() == student.getId());
        if(notExists) {
            students.add(student);
        }
    }

    public void delete(int id) {
        students.stream()
                .filter(s->s.getId() == id)
                .forEach(s->s.setDeleted(true));
    }

    public Student getById(int id) {
        return students.stream()
                .filter(s->s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Student student, int id) {
       students.stream()
                .filter(s->s.getId() == id)
                .forEach(s -> {
                    s.setCoursesTaken(student.getCoursesTaken());
                    s.setMajor(student.getMajor());
                    s.setFirstName(student.getFirstName());
                    s.setLastName(student.getLastName());
                    s.setEmail(student.getEmail());
                });

    }

    public List<Student> getAll() {
        return students.stream()
                .filter(s->!s.isDeleted())
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(s->!s.isDeleted() && s.getMajor() == major)
                .collect(Collectors.toList());
    }


}
