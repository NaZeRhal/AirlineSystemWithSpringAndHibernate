package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.Flight;
import com.rzhe.max.airlines.entities.FlightStatus;

import java.util.List;

public interface FlightDao extends Dao<Flight, Long> {
    List<Flight> findByFlightStatus(FlightStatus flightStatus) throws DaoException;
}
