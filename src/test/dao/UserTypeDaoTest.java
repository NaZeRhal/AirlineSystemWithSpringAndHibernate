package dao;

import com.rzhe.max.airlines.dao.UserTypeDao;
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

public class UserTypeDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserTypeDaoTest.class);

    private GenericApplicationContext context;
    private UserTypeDao userTypeDao;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestAppConfig.class);
        userTypeDao = context.getBean("userTypeDao", UserTypeDao.class);
        assertNotNull(userTypeDao);
    }

    @Test
    public void testFindAll() {
        List<UserType> all = userTypeDao.findAll();
        assertEquals(3, all.size());
        listUserType(all);
    }

    @Test
    public void testFinAllWithUsers() {
        List<UserType> allWithUsers = userTypeDao.findAllWithUsers();
        assertEquals(3, allWithUsers.size());
        listUserTypeWithUsers(allWithUsers);
    }

    @Test
    public void testFindById() {
        UserType userType = userTypeDao.findById(1L);
        assertNotNull(userType);
        logger.info(userType.toString());
    }

    @Test
    public void testInsert() {
        UserType userType = new UserType();
        userType.setName("SERVICE");

        User user = new User();
        user.setFirstName("Bob");
        user.setLastName("Torres");
        user.setLogin("bobby");
        user.setPassword("password");

        user.setUserType(userType);
        userType.addUser(user);

        userTypeDao.save(userType);
        assertNotNull(userType.getId());

        List<UserType> allWithUsers = userTypeDao.findAllWithUsers();
        assertEquals(4, allWithUsers.size());
        listUserTypeWithUsers(allWithUsers);
    }

    @Test
    public void testUpdate() {
        UserType userType = userTypeDao.findById(2L);
        assertNotNull(userType);
        assertEquals("ADMINISTRATOR", userType.getName());

        userType.setName("SERVICE");
        User user = userType.getUserSet().stream()
                .filter(u -> "denisus".equals(u.getLogin()))
                .findFirst()
                .get();
        userType.removeUser(user);

        userTypeDao.save(userType);
        listUserTypeWithUsers(userTypeDao.findAllWithUsers());
    }

    @Test
    public void testDelete() {
        UserType userType = userTypeDao.findById(1L);
        assertNotNull(userType);
        userTypeDao.delete(userType);
        List<UserType> allWithUsers = userTypeDao.findAllWithUsers();
        assertEquals(2, allWithUsers.size());
        listUserTypeWithUsers(allWithUsers);
    }

    @After
    public void tearDown() {
        context.close();
    }

    private static void listUserType(List<UserType> list) {
        logger.info("---- Listing userTypes:");
        list.forEach(userType -> logger.info(userType.toString()));
    }

    private static void listUserTypeWithUsers(List<UserType> list) {
        logger.info("---- Listing userTypes with users:");
        list.forEach(userType -> {
            logger.info(userType.toString());
            if (userType.getUserSet() != null) {
                userType.getUserSet().forEach(user -> logger.info(user.toString()));
            }
        });
    }
}
