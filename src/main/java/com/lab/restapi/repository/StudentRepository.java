package com.lab.restapi.repository;

import com.lab.restapi.entity.Course;
import com.lab.restapi.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findAllByMajor(String major);

    List<Course> findAllById(long id);

    /*

    private static List<Student> students = new ArrayList<>();

    static {
        Student s1 = new Student();
        s1.setId(1l);
        s1.setFirstName("Omur Can");
        s1.setLastName("Boz");
        s1.setEmail("oboz@miu.edu");
        s1.setMajor("COMPRO");

        students.add(s1);

        Student s2 = new Student();
        s2.setId(2l);
        s2.setFirstName("Mehmet Alp");
        s2.setLastName("Basturk");
        s2.setEmail("mbasturk@miu.edu");
        s2.setMajor("COMPRO");

        students.add(s2);

    }

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> getAll() {
        return students;
    }

    public Student getById(long id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public void delete(long id) {
        students.stream().filter(s -> s.getId() == id).forEach(s -> students.remove(s));
    }

     */

}
