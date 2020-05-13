package com.rzhe.max.airlines.dao.daoImpl;

import com.rzhe.max.airlines.dao.CrewManDao;
import com.rzhe.max.airlines.entities.CrewMan;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository("crewManDao")
public class CrewManDaoImpl implements CrewManDao {
    private static final Log logger = LogFactory.getLog(CrewManDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public CrewMan findById(Long id) {
        return (CrewMan) sessionFactory.getCurrentSession()
                .getNamedQuery("CrewMan.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<CrewMan> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from CrewMan c")
                .list();
    }

    @Transactional(readOnly = true)
    public List<CrewMan> findAllWithFlights() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("CrewMan.findAllWithFlights")
                .list();

    }

    public CrewMan save(CrewMan crewMan) {
        sessionFactory.getCurrentSession().saveOrUpdate(crewMan);
        logger.info("CrewMan saved with id: " + crewMan.getId());
        return crewMan;
    }


    public void delete(CrewMan crewMan) {
        sessionFactory.getCurrentSession().delete(crewMan);
        logger.info("CrewMan deleted with id: " + crewMan.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
