package com.rzhe.max.airlines.dao.daoImpl;


import com.rzhe.max.airlines.dao.UserDao;
import com.rzhe.max.airlines.entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private static final Log logger = LogFactory.getLog(UserDaoImpl.class);
    private SessionFactory sessionFactory;

    public User findByLogin(String login) {
        return (User) sessionFactory.getCurrentSession()
                .getNamedQuery("User.findByLogin")
                .setParameter("login", login)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return (User) sessionFactory.getCurrentSession()
                .getNamedQuery("User.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User u")
                .list();
    }

    public User save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        logger.info("User saved with id: " + user.getId());
        return user;
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
        logger.info("User deleted with id: " + user.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
