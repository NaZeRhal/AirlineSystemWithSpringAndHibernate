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
        return (Airport) sessionFactory.getCurrentSession()
                .getNamedQuery("Airport.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<Airport> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("select a from Airport a")
                .list();
    }

    @Transactional(readOnly = true)
    public List<Airport> findAllWithFlights() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Airport.findAllWithFlights")
                .list();
    }

    public Airport save(Airport airport) {
        sessionFactory.getCurrentSession().saveOrUpdate(airport);
        logger.info("Airport saved with id: " + airport.getId());
        return airport;
    }


    public void delete(Airport airport) {
        sessionFactory.getCurrentSession().delete(airport);
        logger.info("Airport deleted with id: " + airport.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
