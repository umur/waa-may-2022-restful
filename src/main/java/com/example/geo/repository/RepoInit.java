package com.example.geo.repository;

import java.util.List;

public interface RepoInit<T> {

   List<T> getAll();

    void save(T t);

    void update(int id,T t);

    void delete(int id);

    T getById(int id);
}
