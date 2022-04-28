package com.lab.Restful.repo;

import com.lab.Restful.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//create, read, update and delete.

@Repository
public interface CourseRepo extends CrudRepository<Course,Integer>{
    void deleteById(int id);
    List<Course> findAllById(int id);

    List<Course> findAll();
    <S extends Course> S save(S entity);
    <S extends Course> Iterable<S> saveAll(Iterable<S> entities);
}
