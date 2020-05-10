package com.rzhe.max.airlines.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, PK extends Serializable> {
    T findById(PK id);

    List<T> findAll();

    PK create(T entity);

    void update(T entity);

    void delete(PK id);

}
