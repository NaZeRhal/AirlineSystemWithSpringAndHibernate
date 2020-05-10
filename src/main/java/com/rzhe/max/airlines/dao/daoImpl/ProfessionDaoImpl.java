package com.rzhe.max.airlines.dao.daoImpl;


import com.rzhe.max.airlines.dao.ProfessionDao;
import com.rzhe.max.airlines.entities.Profession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository("professionDao")
public class ProfessionDaoImpl implements ProfessionDao {
    private static final Log logger = LogFactory.getLog(ProfessionDaoImpl.class);
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public Profession findById(Long id) {
        return (Profession) sessionFactory.getCurrentSession()
                .getNamedQuery("Profession.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Profession> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Profession p")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Profession> findAllWithCrewMen() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Profession.findAllWithCrewMen")
                .list();
    }

    @Override
    public Long create(Profession entity) {
        return null;
    }

    @Override
    public void update(Profession entity) {

    }

    @Override
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
