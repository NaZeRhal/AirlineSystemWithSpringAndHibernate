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
    public Profession findById(Long id) {
        return (Profession) sessionFactory.getCurrentSession()
                .getNamedQuery("Profession.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<Profession> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Profession p")
                .list();
    }

    @Transactional(readOnly = true)
    public List<Profession> findAllWithCrewMen() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Profession.findAllWithCrewMen")
                .list();
    }

    public Profession save(Profession profession) {
        sessionFactory.getCurrentSession().saveOrUpdate(profession);
        logger.info("Profession saved with id: " + profession.getId());
        return profession;
    }

    public void delete(Profession profession) {
        sessionFactory.getCurrentSession().delete(profession);
        logger.info("Profession deleted with id: " + profession.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
