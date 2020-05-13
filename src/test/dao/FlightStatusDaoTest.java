package dao;

import com.rzhe.max.airlines.dao.FlightStatusDao;
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

public class FlightStatusDaoTest {
    private static Logger logger = LoggerFactory.getLogger(FlightStatusDaoTest.class);

    private GenericApplicationContext context;
    private FlightStatusDao flightStatusDao;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
        flightStatusDao = context.getBean("flightStatusDao", FlightStatusDao.class);
    }

    @Test
    public void testFindAll() {
        List<FlightStatus> all = flightStatusDao.findAll();
        assertEquals(8, all.size());
        listFlightStatus(all);
    }

    @Test
    public void testFindAllWithFlights() {
        List<FlightStatus> allWithFlights = flightStatusDao.findAllWithFlights();
        assertEquals(8, allWithFlights.size());
        listFlightStatusWithFlights(allWithFlights);
    }

    @Test
    public void testFindById() {
        FlightStatus status = flightStatusDao.findById(1L);
        assertNotNull(status);
        logger.info(status.toString());
    }

    @Test
    public void testInsert() {
        FlightStatus flightStatus = new FlightStatus();
        flightStatus.setName("NONE");

        Airport departure = new Airport();
        departure.setId(1L);
        Airport arrival = new Airport();
        arrival.setId(2L);

        Flight flight = new Flight();
        flight.setFlightCode("DFRS3121");
        flight.setDepartureTime(LocalDateTime.of(2020, 6, 23, 13, 20));
        flight.setArrivalTime(LocalDateTime.of(2020, 6, 23, 15, 40));
        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);

        flight.setFlightStatus(flightStatus);
        flightStatus.addFlight(flight);

        flightStatusDao.save(flightStatus);
        assertNotNull(flightStatus.getId());

        List<FlightStatus> allWithFlights = flightStatusDao.findAllWithFlights();
        assertEquals(9, allWithFlights.size());
        listFlightStatusWithFlights(allWithFlights);
    }

    @Test
    public void testUpdate() {
        FlightStatus status = flightStatusDao.findById(1L);
        assertNotNull(status);
        assertEquals("OPENED", status.getName());
        status.setName("NONE");

        Flight flight = status.getFlights().stream().filter(f -> "Minsk".equals(f.getDepartureAirport().getCity()))
                .findFirst().get();
        status.removeFlight(flight);

        flightStatusDao.save(status);
        listFlightStatusWithFlights(flightStatusDao.findAllWithFlights());
    }

    @Test
    public void testDelete() {
        FlightStatus status = flightStatusDao.findById(1L);
        assertNotNull(status);
        flightStatusDao.delete(status);
        List<FlightStatus> allWithFlights = flightStatusDao.findAllWithFlights();
        assertEquals(7, allWithFlights.size());
        listFlightStatusWithFlights(allWithFlights);
    }

    @After
    public void tearDown() {
        context.close();
    }

    private static void listFlightStatus(List<FlightStatus> list) {
        logger.info("-----Listing Flight Statuses:");
        list.forEach(flightStatus -> logger.info(flightStatus.toString()));
    }

    private static void listFlightStatusWithFlights(List<FlightStatus> list) {
        logger.info("-----Listing flight statuses with flights:");
        list.forEach(flightStatus -> {
            logger.info(flightStatus.toString());
            if (flightStatus.getFlights() != null) {
                flightStatus.getFlights().forEach(flight -> logger.info("\t" + flight.toString()));
            }
        });
    }
}
