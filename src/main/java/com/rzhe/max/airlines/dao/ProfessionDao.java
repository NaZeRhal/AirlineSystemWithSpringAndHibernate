package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.Profession;

import java.util.List;

public interface ProfessionDao {
    Profession findById(Long id);

    List<Profession> findAll();

    List<Profession> findAllWithCrewMen();

    Profession save(Profession profession);

    void delete(Profession profession);
}
