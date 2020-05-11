package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.Flight;
import com.rzhe.max.airlines.entities.FlightStatus;

import java.util.List;

public interface FlightDao {
    Flight findById(Long id);

    List<Flight> findAll();

    Long create(Flight flight);

    void update(Flight flight);

    void delete(Long id);

    List<Flight> findByFlightStatus(FlightStatus flightStatus);
}
