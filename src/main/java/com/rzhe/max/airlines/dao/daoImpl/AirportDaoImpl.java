package com.rzhe.max.airlines.dao.daoImpl;

import com.rzhe.max.airlines.dao.AirportDao;
import com.rzhe.max.airlines.entities.Airport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository("airportDao")
public class AirportDaoImpl implements AirportDao {

    private static final Log logger = LogFactory.getLog(AirportDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public Airport findByAirportCode(String airportCode) {
        return null;
    }

    @Transactional(readOnly = true)
    public Airport findById(Long id) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<Airport> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("select a from Airport a")
                .list();
    }


    public Long create(Airport entity) {
        return null;
    }

    public void update(Airport entity) {

    }

    public void delete(Long id) {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
