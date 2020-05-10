package com.rzhe.max.airlines.dao.daoImpl;

import com.rzhe.max.airlines.dao.DaoException;
import com.rzhe.max.airlines.dao.FlightDao;
import com.rzhe.max.airlines.entities.Flight;
import com.rzhe.max.airlines.entities.FlightStatus;

import java.util.List;

public class FlightDaoImpl implements FlightDao {

//    @Override
//    public String getSelectQuery() {
//        return "SELECT a.id, a.flight_code, b.id as depair_id, b.city as depair_city, b.airport_code as depair_code, " +
//                "       c.id as arrair_id, c.city as arrair_city, c.airport_code as arrair_code, " +
//                "       a.departure_time, a.arrival_time, a.flight_status_id FROM flights a, airport b, airport c " +
//                "WHERE a.departure_airport_id = b.id AND a.arrival_airport_id = c.id";
//    }
//
//    @Override
//    public String getCreateQuery() {
//        return "INSERT INTO flights (flight_code, departure_airport_id, arrival_airport_id, departure_time, " +
//                "arrival_time, flight_status_id) VALUES (?,?,?,?,?,?)";
//    }
//
//    @Override
//    public String getUpdateQuery() {
//        return "UPDATE flights SET flight_code = ?, departure_airport_id = ?, arrival_airport_id = ?, departure_time = ?," +
//                "arrival_time = ?, flight_status_id = ? WHERE id = ?";
//    }
//
//    @Override
//    public String getDeleteQuery() {
//        return "DELETE FROM flights WHERE id = ?";
//    }


    @Override
    public List<Flight> findByFlightStatus(FlightStatus flightStatus) {
        return null;
    }

    @Override
    public Flight findById(Long id)  {
        return null;
    }

    @Override
    public List<Flight> findAll()  {
        return null;
    }

    @Override
    public Long create(Flight entity)  {
        return null;
    }

    @Override
    public void update(Flight entity)  {

    }

    @Override
    public void delete(Long id) {

    }
}
