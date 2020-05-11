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

    public Long create(CrewMan entity) {
        return null;
    }

    public void update(CrewMan entity) {

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
