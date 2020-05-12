package com.rzhe.max.airlines.dao.daoImpl;

import com.rzhe.max.airlines.dao.FlightStatusDao;
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
@Repository("flightStatusDao")
public class FlightStatusDaoImpl implements FlightStatusDao {
    private static final Log logger = LogFactory.getLog(FlightStatusDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public FlightStatus findById(Long id) {
        return (FlightStatus) sessionFactory.getCurrentSession()
                .getNamedQuery("FlightStatus.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<FlightStatus> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from FlightStatus f")
                .list();
    }

    @Transactional(readOnly = true)
    public List<FlightStatus> findAllWithFlights() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("FlightStatus.findAllWithFlights")
                .list();
    }

    public FlightStatus save(FlightStatus flightStatus) {
        sessionFactory.getCurrentSession().saveOrUpdate(flightStatus);
        logger.info("FlightStatus saved with id: " + flightStatus.getId());
        return flightStatus;
    }


    public void delete(FlightStatus flightStatus) {
        sessionFactory.getCurrentSession().delete(flightStatus);
        logger.info("FlightStatus deleted with id: " + flightStatus.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
