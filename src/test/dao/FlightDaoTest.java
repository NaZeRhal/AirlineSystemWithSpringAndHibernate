package dao;

import com.rzhe.max.airlines.dao.FlightDao;
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

public class FlightDaoTest {
    private static Logger logger = LoggerFactory.getLogger(FlightDaoTest.class);

    private GenericApplicationContext context;
    private FlightDao flightDao;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
        flightDao = context.getBean("flightDao", FlightDao.class);
    }

    @Test
    public void testFindAll() {
        List<Flight> all = flightDao.findAll();
        assertEquals(4, all.size());
        listFlights(all);
    }

    @Test
    public void testFindAllWithCrewMen() {
        List<Flight> allWithCrewMen = flightDao.findAllWithCrewMen();
        assertEquals(4, allWithCrewMen.size());
        listFlightsWithCrewMen(allWithCrewMen);

    }

    @Test
    public void testFindById() {
        Flight flight = flightDao.findById(1L);
        assertNotNull(flight);
        logger.info(flight.toString());
    }

    @Test
    public void testInsert() {
        Airport departure = new Airport();
        departure.setId(1L);
        Airport arrival = new Airport();
        arrival.setId(2L);

        FlightStatus flightStatus = new FlightStatus();
        flightStatus.setId(8L);

        Flight flight = new Flight();
        flight.setFlightCode("DFRS3121");
        flight.setDepartureTime(LocalDateTime.of(2020, 6, 23, 13, 20));
        flight.setArrivalTime(LocalDateTime.of(2020, 6, 23, 15, 40));
        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);
        flight.setFlightStatus(flightStatus);

        flightDao.save(flight);
        assertNotNull(flight.getId());

        List<Flight> all = flightDao.findAll();
        assertEquals(5, all.size());
        listFlights(all);

    }

    @Test
    public void testUpdate() {
        Flight flight = flightDao.findById(1L);
        assertNotNull(flight);
        assertEquals("LESI4199", flight.getFlightCode());

        flight.setFlightCode("EEEE1111");
        flight.setDepartureTime(LocalDateTime.of(2020, 3, 29, 19, 50));

        flightDao.save(flight);
        listFlights(flightDao.findAll());
    }

    @Test
    public void testDelete() {
        Flight flight = flightDao.findById(1L);
        assertNotNull(flight);
        flightDao.delete(flight);
        List<Flight> all = flightDao.findAll();
        assertEquals(3, all.size());
        listFlights(all);
    }

    @After
    public void tearDown() {
        context.close();
    }

    private static void listFlights(List<Flight> list) {
        logger.info("-----Listing flights:");
        list.forEach(flight -> logger.info(flight.toString()));
    }

    private static void listFlightsWithCrewMen(List<Flight> list) {
        logger.info("-----Listing flights:");
        list.forEach(flight -> {
            logger.info(flight.toString());
            if (flight.getCrewManList() != null) {
                flight.getCrewManList().forEach(crewMan -> logger.info(crewMan.toString()));
            }
        });
    }

}
