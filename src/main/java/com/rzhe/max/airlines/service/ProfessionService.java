package com.rzhe.max.airlines.service;

import com.rzhe.max.airlines.entities.Profession;

import java.util.List;

public interface ProfessionService {
    Profession findById(Long id);

    List<Profession> findAll();

    List<Profession> findAllWithCrewMen();

    Profession save(Profession profession);

    void delete(Profession profession);
}
