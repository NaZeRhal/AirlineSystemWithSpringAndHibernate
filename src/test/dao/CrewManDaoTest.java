package dao;

import com.rzhe.max.airlines.dao.CrewManDao;
import com.rzhe.max.airlines.entities.CrewMan;
import com.rzhe.max.airlines.entities.Profession;
import config.TestAppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CrewManDaoTest {
    private static Logger logger = LoggerFactory.getLogger(CrewManDaoTest.class);

    private GenericApplicationContext context;
    private CrewManDao crewManDao;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
        crewManDao = context.getBean("crewManDao", CrewManDao.class);
        assertNotNull(crewManDao);
    }

    @Test
    public void testFindAll() {
        List<CrewMan> all = crewManDao.findAll();
        assertEquals(8, all.size());
        listCrewMen(all);
    }

    @Test
    public void testFindAllWithFlights() {
        List<CrewMan> allWithFlights = crewManDao.findAllWithFlights();
        assertEquals(8, allWithFlights.size());
        listCrewMenWithFlights(allWithFlights);
    }

    @Test
    public void testFindById() {
        CrewMan crewMan = crewManDao.findById(1L);
        assertNotNull(crewMan);
        logger.info(crewMan.toString());
    }

    @Test
    public void testInsert() {
        Profession profession = new Profession();
        profession.setId(1L);

        CrewMan crewMan = new CrewMan();
        crewMan.setFirstName("Mark");
        crewMan.setLastName("Markov");
        crewMan.setDateOfBirth(LocalDate.of(1986, 10, 12));
        crewMan.setProfession(profession);

        crewManDao.save(crewMan);
        assertNotNull(crewMan.getId());

        List<CrewMan> crewManList = crewManDao.findAll();
        assertEquals(9, crewManList.size());
        listCrewMen(crewManList);
    }

    @Test
    public void testUpdate() {
        CrewMan crewMan = crewManDao.findById(1L);
        assertNotNull(crewMan);
        assertEquals("Darius", crewMan.getFirstName());

        Profession profession = new Profession();
        profession.setId(2L);

        crewMan.setFirstName("Poul");
        crewMan.setProfession(profession);

        crewManDao.save(crewMan);
        listCrewMen(crewManDao.findAll());
    }

    @Test
    public void testDelete() {
        CrewMan crewMan = crewManDao.findById(1L);
        assertNotNull(crewMan);
        crewManDao.delete(crewMan);
        List<CrewMan> all = crewManDao.findAll();
        assertEquals(7, all.size());
        listCrewMen(all);
    }

    @After
    public void tearDown() {
        context.close();
    }

    private static void listCrewMen(List<CrewMan> list) {
        logger.info("---- Listing crewmen:");
        list.forEach(crewMan -> logger.info(crewMan.toString()));
    }

    private static void listCrewMenWithFlights(List<CrewMan> list) {
        logger.info("---- Listing crewmen:");
        list.forEach(crewMan -> {
            logger.info(crewMan.toString());
            if (crewMan.getFlights() != null) {
                crewMan.getFlights().forEach(flight -> logger.info("\t" + flight.toString()));
            }
        });
    }
}
