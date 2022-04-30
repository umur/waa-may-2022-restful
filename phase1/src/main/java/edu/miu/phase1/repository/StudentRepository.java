package edu.miu.phase1.repository;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();
    static {
        Student studentSerdar = new Student(1,"Serdar","Isikli","serdarisikli@gmail.com","Computer Science");
        Student studentBahar= new Student(2,"Bahar","Isikli","bahar@gmail.com","Accounting");
        Student studentArin= new Student(3, "Arin", "Isikli", "arinisikli@gmail.com", "Medicine");
        Course course1 = new Course(1,"Calculus","Cal101");
        Course course2 = new Course(2,"Biology","Bio101");
        Course course3 = new Course(3,"Chemistry","Chem101");
        studentSerdar.addCourse(course1);
        studentSerdar.addCourse(course2);
        studentSerdar.addCourse(course3);
        studentBahar.addCourse(course1);
        studentBahar.addCourse(course3);
        studentArin.addCourse(course1);
        students.add(studentSerdar);
        students.add(studentBahar);
        students.add(studentArin);
    }


    public void save(Student student) {
        students.add(student);
    }

    public void update(Student student, int id) {
        var isExist = students.stream().filter(s -> s.getId() == id)
                .findFirst();
        if(isExist.isPresent()) {
            students.remove(isExist.get());
            students.add(student);
        }
    }

    public void delete(int id) {
        var isExist = students.stream().filter(s -> s.getId() == id)
                .findFirst();
        if(isExist.isPresent()) {
            students.remove(isExist.get());
        }
    }

    public List<Student> findAll(){
        return students;
    }

    public Student findById(int id){
        return students.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public List<Student> findStudentsByMajor(String major) {
        return  students.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

}
