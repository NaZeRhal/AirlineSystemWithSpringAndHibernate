package com.rzhe.max.airlines.dao.daoImpl;

import com.rzhe.max.airlines.dao.UserTypeDao;
import com.rzhe.max.airlines.entities.UserType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository("userTypeDao")
public class UserTypeDaoImpl implements UserTypeDao {

    private static final Log logger = LogFactory.getLog(UserTypeDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public UserType findById(Long id) {
        return (UserType) sessionFactory.getCurrentSession()
                .getNamedQuery("UserType.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserType> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from UserType u")
                .list();
    }

    @Transactional(readOnly = true)
    public List<UserType> findAllWithUsers() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("UserType.findAllWithUsers")
                .list();
    }

    public UserType save(UserType userType) {
        sessionFactory.getCurrentSession().saveOrUpdate(userType);
        logger.info("UserType saved with id: " + userType.getId());
        return userType;
    }


    public void delete(UserType userType) {
        sessionFactory.getCurrentSession().delete(userType);
        logger.info("UserType deleted with id: " + userType.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
