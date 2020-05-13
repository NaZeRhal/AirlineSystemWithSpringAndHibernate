package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.CrewMan;

import java.util.List;

public interface CrewManDao {
    CrewMan findById(Long id);

    List<CrewMan> findAll();

    List<CrewMan> findAllWithFlights();

    CrewMan save(CrewMan crewMan);

    void delete(CrewMan crewMan);
}
