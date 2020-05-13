package com.rzhe.max.airlines.dao.daoImpl;

import com.rzhe.max.airlines.dao.FlightDao;
import com.rzhe.max.airlines.entities.Flight;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository("flightDao")
public class FlightDaoImpl implements FlightDao {
    private static final Log logger = LogFactory.getLog(FlightDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public Flight findById(Long id) {
        return (Flight) sessionFactory.getCurrentSession()
                .getNamedQuery("Flight.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<Flight> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Flight f")
                .list();
    }

    @Transactional(readOnly = true)
    public List<Flight> findAllWithCrewMen() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Flight.findAllWithCrewMen")
                .list();
    }

    public Flight save(Flight flight) {
        sessionFactory.getCurrentSession().saveOrUpdate(flight);
        logger.info("Flight saved with id: " + flight.getId());
        return flight;
    }

    public void delete(Flight flight) {
        sessionFactory.getCurrentSession().delete(flight);
        logger.info("Flight deleted with id: " + flight.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
