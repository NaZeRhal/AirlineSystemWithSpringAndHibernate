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

    public User findByLogin(String login){
        return null;
    }

    @Transactional(readOnly = true)
    public User findById(Long id)  {
        return (User) sessionFactory.getCurrentSession()
                .getNamedQuery("User.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<User> findAll()  {
        return sessionFactory.getCurrentSession()
                .createQuery("from User u")
                .list();
    }

    public Long create(User user)  {
        return null;
    }

    public void update(User user)  {

    }

    public void delete(Long id)  {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
