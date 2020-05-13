package dao;

import com.rzhe.max.airlines.dao.ProfessionDao;
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

public class ProfessionDaoTest {
    private static Logger logger = LoggerFactory.getLogger(ProfessionDaoTest.class);

    private GenericApplicationContext context;
    private ProfessionDao professionDao;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
        professionDao = context.getBean("professionDao", ProfessionDao.class);
        assertNotNull(professionDao);
    }

    @Test
    public void testFindAll() {
        List<Profession> professions = professionDao.findAll();
        assertEquals(4, professions.size());
        listProfessions(professions);
    }

    @Test
    public void testFindAllWithCrewMen() {
        List<Profession> allWithCrewMen = professionDao.findAllWithCrewMen();
        assertEquals(4, allWithCrewMen.size());
        listProfessionsWithCrewMen(allWithCrewMen);
    }

    @Test
    public void testFindById() {
        Profession profession = professionDao.findById(1L);
        assertNotNull(profession);
        logger.info(profession.toString());
    }

    @Test
    public void testInsert() {
        Profession profession = new Profession();
        profession.setName("MECHANIC");

        CrewMan crewMan = new CrewMan();
        crewMan.setFirstName("Mark");
        crewMan.setLastName("Markov");
        crewMan.setDateOfBirth(LocalDate.of(1986, 10, 12));
        crewMan.setProfession(profession);
        profession.addCrewMan(crewMan);

        professionDao.save(profession);
        assertNotNull(profession.getId());

        List<Profession> professions = professionDao.findAllWithCrewMen();
        assertEquals(5, professions.size());
        listProfessionsWithCrewMen(professions);
    }

    @Test
    public void testUpdate() {
        Profession profession = professionDao.findById(1L);
        assertNotNull(profession);
        assertEquals("PILOT", profession.getName());

        profession.setName("MECHANIC");
        CrewMan man = profession.getCrewMEN().stream()
                .filter(crewMan -> "Darius".equals(crewMan.getFirstName()))
                .findFirst()
                .get();
        profession.removeCrewMan(man);

        professionDao.save(profession);
        listProfessionsWithCrewMen(professionDao.findAllWithCrewMen());
    }

    @Test
    public void testDelete() {
        Profession profession = professionDao.findById(1L);
        assertNotNull(profession);
        professionDao.delete(profession);
        List<Profession> allWithCrewMen = professionDao.findAllWithCrewMen();
        assertEquals(3, allWithCrewMen.size());
        listProfessionsWithCrewMen(allWithCrewMen);
    }

    @After
    public void tearDown() {
        context.close();
    }

    private static void listProfessions(List<Profession> list) {
        logger.info("---- Listing professions:");
        list.forEach(profession -> logger.info(profession.toString()));
    }

    private static void listProfessionsWithCrewMen(List<Profession> list) {
        logger.info("---- Listing professions with crewmen:");
        list.forEach(profession ->
        {
            logger.info(profession.toString());
            if (profession.getCrewMEN() != null) {
                profession.getCrewMEN().forEach(crewMan -> logger.info("\t" + crewMan.toString()));
            }
        });
    }
}
