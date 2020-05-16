package dao;


import com.rzhe.max.airlines.dao.AirportDao;
import com.rzhe.max.airlines.entities.Airport;
import com.rzhe.max.airlines.entities.Flight;
import com.rzhe.max.airlines.entities.FlightStatus;
import config.TestAppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AirportDaoTest {
    private static Logger logger = LoggerFactory.getLogger(AirportDaoTest.class);

    private GenericApplicationContext context;
    private AirportDao airportDao;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
        airportDao = context.getBean("airportDao", AirportDao.class);
        assertNotNull(airportDao);
    }

    @Test
    public void testFindAll() {
        List<Airport> airports = airportDao.findAll();
        assertEquals(4, airports.size());
        listAirports(airports);
    }

    @Test
    public void testFindAllWithFlights() {
        List<Airport> allWithFlights = airportDao.findAllWithFlights();
        assertEquals(4, allWithFlights.size());
        listAirportsWithFlights(allWithFlights);

    }

    @Test
    public void testFindById() {
        Airport airport = airportDao.findById(1L);
        assertNotNull(airport);
        logger.info(airport.toString());
        if (airport.getDepartures() != null) {
            airport.getDepartures().forEach(flight -> logger.info("\t" + flight.toString()));
        }
        if (airport.getArrivals() != null) {
            airport.getArrivals().forEach(flight -> logger.info("\t" + flight.toString()));
        }

    }

    @Test
    public void testInsert() {
        Airport departure = new Airport();
        departure.setCity("Magadan");
        departure.setAirportCode("MGD");

        Airport arrival = new Airport();
        arrival.setId(1L);

        FlightStatus flightStatus = new FlightStatus();
        flightStatus.setId(1L);

        Flight flight = new Flight();
        flight.setFlightCode("DFRS3121");
        flight.setDepartureTime(LocalDateTime.of(2020, 6, 23, 13, 20));
        flight.setArrivalTime(LocalDateTime.of(2020, 6, 23, 15, 40));
        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);
        flight.setFlightStatus(flightStatus);

        departure.addDepartures(flight);
        arrival.addArrivals(flight);
        airportDao.save(departure);

        assertNotNull(departure.getId());
        assertNotNull(arrival.getId());

        List<Airport> all = airportDao.findAll();
        assertEquals(5, all.size());
        listAirports(all);
    }

    @Test
    public void testUpdate() {
        Airport airport = airportDao.findById(1L);
        assertNotNull(airport);
        assertEquals("VKO", airport.getAirportCode());

        airport.setCity("Prague");
        airport.setAirportCode("PRG");

        airportDao.save(airport);

        listAirports(airportDao.findAll());
    }

    @Test
    public void testDelete() {
        Airport airport = airportDao.findById(1L);
        assertNotNull(airport);
        airportDao.delete(airport);
        List<Airport> all = airportDao.findAll();
        assertEquals(3, all.size());
        listAirports(all);
    }

    @After
    public void tearDown() {
        context.close();
    }

    private static void listAirports(List<Airport> list) {
        logger.info("---- Listing airports:");
        list.forEach(airport -> logger.info(airport.toString()));
    }

    private static void listAirportsWithFlights(List<Airport> list) {
        logger.info("---- Listing airports:");
        list.forEach(airport -> {
            logger.info(airport.toString());
            if (airport.getDepartures() != null) {
                airport.getDepartures().forEach(flight -> logger.info("\t" + flight.toString()));
            }
            if (airport.getArrivals() != null) {
                airport.getArrivals().forEach(flight -> logger.info("\t" + flight.toString()));
            }
        });
    }

}
