package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.FlightStatus;

import java.util.List;

public interface FlightStatusDao {
    FlightStatus findById(Long id);

    List<FlightStatus> findAll();

    List<FlightStatus> findAllWithCrewMen();

    Long create(FlightStatus profession);

    void update(FlightStatus profession);

    void delete(Long id);
}
