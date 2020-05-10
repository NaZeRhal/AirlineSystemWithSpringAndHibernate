package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.Airport;

import java.util.List;

public interface AirportDao {
    Airport findById(Long id);

    List<Airport> findAll();

    Long create(Airport airport);

    void update(Airport airport);

    void delete(Long id);

    Airport findByAirportCode(String airportCode);
}
