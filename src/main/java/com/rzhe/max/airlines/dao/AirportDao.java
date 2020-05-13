package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.Airport;

import java.util.List;

public interface AirportDao {
    Airport findById(Long id);

    List<Airport> findAll();

    Airport save(Airport airport);

    void delete(Airport airport);

    Airport findByAirportCode(String airportCode);
}
