package com.lab.Restful.repo;

import com.lab.Restful.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
        void deleteById(int id);
        Student findById(int id);
        Student findByFirstNameAndLastName(String firstname, String lastname);
        List<Student> findAllByMajor(String major);

        List<Student> findAll();

        <S extends Student> S save(S entity);
}
