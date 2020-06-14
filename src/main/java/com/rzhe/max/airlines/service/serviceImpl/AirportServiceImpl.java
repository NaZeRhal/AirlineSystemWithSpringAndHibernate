package com.rzhe.max.airlines.service.serviceImpl;

import com.rzhe.max.airlines.dao.AirportDao;
import com.rzhe.max.airlines.entities.Airport;
import com.rzhe.max.airlines.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("airportService")
@Transactional
public class AirportServiceImpl implements AirportService {
    private AirportDao airportDao;

    @Autowired
    public void setAirportDao(AirportDao airportDao) {
        this.airportDao = airportDao;
    }

    @Transactional(readOnly = true)
    @Override
    public Airport findById(Long id) {
        return airportDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Airport> findAll() {
        return airportDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Airport> findAllWithFlights() {
        return airportDao.findAllWithFlights();
    }

    @Transactional
    @Override
    public Airport save(Airport airport) {
        return airportDao.save(airport);
    }

    @Transactional
    @Override
    public void delete(Airport airport) {
        airportDao.delete(airport);
    }

    @Transactional
    @Override
    public Airport findByAirportCode(String airportCode) {
        return airportDao.findByAirportCode(airportCode);
    }
}
