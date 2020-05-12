package dao;

import com.rzhe.max.airlines.dao.UserDao;
import com.rzhe.max.airlines.entities.User;
import com.rzhe.max.airlines.entities.UserType;
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

public class UserDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    private GenericApplicationContext context;
    private UserDao userDao;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
        userDao = context.getBean("userDao", UserDao.class);
    }

    @Test
    public void testFindAll() {
        List<User> all = userDao.findAll();
        assertEquals(4, all.size());
        listUsers(all);
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(1L);
        assertNotNull(user);
        logger.info(user.toString());
    }

    @Test
    public void testFindByLogin() {
        User user = userDao.findByLogin("maximus");
        assertNotNull(user);
        logger.info(user.toString());
    }

    @Test
    public void testInsert() {
        UserType userType = new UserType();
        userType.setId(1L);

        User user = new User();
        user.setFirstName("Bob");
        user.setLastName("Torres");
        user.setLogin("bobby");
        user.setPassword("password");
        user.setUserType(userType);

        userDao.save(user);
        assertNotNull(user.getId());

        List<User> all = userDao.findAll();
        assertEquals(5, all.size());
        listUsers(all);
    }

    @Test
    public void testUpdate() {
        User user = userDao.findById(1L);
        assertNotNull(user);
        assertEquals("maximus", user.getLogin());

        user.setFirstName("Leopold");

        UserType userType = new UserType();
        userType.setId(3L);
        user.setUserType(userType);

        userDao.save(user);
        listUsers(userDao.findAll());

    }

    @Test
    public void testDelete() {
        User user = userDao.findById(1L);
        assertNotNull(user);
        userDao.delete(user);
        List<User> all = userDao.findAll();
        assertEquals(3, all.size());
        listUsers(all);
    }

    @After
    public void tearDown() {
        context.close();
    }

    private static void listUsers(List<User> list) {
        logger.info("-----Listing users:");
        list.forEach(user -> logger.info(user.toString()));
    }
}
