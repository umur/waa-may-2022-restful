package com.example.geo.service;

import java.util.List;

public interface ServiceInit<T> {

    List<T> getAll();

    void save(T t);

    void update(int id,T t);

    void delete(int id);

    T getById(int id);
}
