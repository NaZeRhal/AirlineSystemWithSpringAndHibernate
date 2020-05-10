package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.Profession;

import java.util.List;

public interface ProfessionDao {
    Profession findById(Long id);

    List<Profession> findAll();

    List<Profession> findAllWithCrewMen();

    Long create(Profession profession);

    void update(Profession profession);

    void delete(Long id);
}
