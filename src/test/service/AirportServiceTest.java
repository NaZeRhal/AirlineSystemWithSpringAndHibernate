package service;

import com.rzhe.max.airlines.entities.Airport;
import com.rzhe.max.airlines.service.AirportService;
import config.TestAppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AirportServiceTest {
    private static Logger logger = LoggerFactory.getLogger(AirportServiceTest.class);

    private GenericApplicationContext context;
    private AirportService airportService;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
        airportService = context.getBean("airportService", AirportService.class);
        assertNotNull(airportService);
    }

    @Test
    public void testFindAll() {
        List<Airport> airports = airportService.findAll();
        assertEquals(4, airports.size());
        listAirports(airports);
    }

    private static void listAirports(List<Airport> list) {
        logger.info("---- Listing airports:");
        list.forEach(airport -> logger.info(airport.toString()));
    }

    @After
    public void tearDown() {
        context.close();
    }
}
