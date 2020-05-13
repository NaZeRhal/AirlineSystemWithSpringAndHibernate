package dao;


import com.rzhe.max.airlines.dao.AirportDao;
import com.rzhe.max.airlines.entities.Airport;
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

public class AirportDaoTest {
    private static Logger logger = LoggerFactory.getLogger(AirportDao.class);

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
    public void testFindById() {
        Airport airport = airportDao.findById(1L);
        assertNotNull(airport);
        logger.info(airport.toString());
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

}
