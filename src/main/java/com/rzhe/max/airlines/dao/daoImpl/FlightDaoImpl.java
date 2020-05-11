package com.rzhe.max.airlines.dao.daoImpl;

import com.rzhe.max.airlines.dao.FlightDao;
import com.rzhe.max.airlines.entities.Flight;
import com.rzhe.max.airlines.entities.FlightStatus;
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
    public Flight findById(Long id)  {
        return null;
    }

    @Transactional(readOnly = true)
    public List<Flight> findAll()  {
        return sessionFactory.getCurrentSession()
                .createQuery("from Flight f")
                .list();
    }

    @Transactional(readOnly = true)
    public List<Flight> findByFlightStatus(FlightStatus flightStatus) {
        return null;
    }

    public Long create(Flight entity)  {
        return null;
    }

    public void update(Flight entity)  {

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
