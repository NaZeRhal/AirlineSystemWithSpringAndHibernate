package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.CrewMan;

import java.util.List;

public interface CrewManDao {
    CrewMan findById(Long id);

    List<CrewMan> findAll();

    Long create(CrewMan entity);

    void update(CrewMan entity);

    void delete(Long id);
}
