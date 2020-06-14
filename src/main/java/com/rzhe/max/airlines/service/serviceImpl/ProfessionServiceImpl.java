package com.rzhe.max.airlines.service.serviceImpl;

import com.rzhe.max.airlines.dao.ProfessionDao;
import com.rzhe.max.airlines.entities.Profession;
import com.rzhe.max.airlines.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("professionService")
@Transactional
public class ProfessionServiceImpl implements ProfessionService {
    private ProfessionDao professionDao;

    @Autowired
    public void setProfessionDao(ProfessionDao professionDao) {
        this.professionDao = professionDao;
    }

    @Transactional(readOnly = true)
    @Override
    public Profession findById(Long id) {
        return professionDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Profession> findAll() {
        return professionDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Profession> findAllWithCrewMen() {
        return professionDao.findAllWithCrewMen();
    }

    @Override
    public Profession save(Profession profession) {
        return professionDao.save(profession);
    }

    @Override
    public void delete(Profession profession) {
        professionDao.delete(profession);
    }
}
