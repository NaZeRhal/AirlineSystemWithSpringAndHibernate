package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.Flight;

import java.util.List;

public interface FlightDao {
    Flight findById(Long id);

    List<Flight> findAll();

    Flight save(Flight flight);

    void delete(Flight flight);

}
