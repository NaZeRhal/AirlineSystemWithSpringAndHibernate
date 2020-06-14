package com.rzhe.max.airlines.service.serviceImpl;

import com.rzhe.max.airlines.dao.CrewManDao;
import com.rzhe.max.airlines.entities.CrewMan;
import com.rzhe.max.airlines.service.CrewManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("crewManService")
@Transactional
public class CrewManServiceImpl implements CrewManService {
    private CrewManDao crewManDao;

    @Autowired
    public void setCrewManDao(CrewManDao crewManDao) {
        this.crewManDao = crewManDao;
    }

    @Transactional(readOnly = true)
    @Override
    public CrewMan findById(Long id) {
        return crewManDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CrewMan> findAll() {
        return crewManDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<CrewMan> findAllWithFlights() {
        return crewManDao.findAllWithFlights();
    }

    @Override
    public CrewMan save(CrewMan crewMan) {
        return crewManDao.save(crewMan);
    }

    @Override
    public void delete(CrewMan crewMan) {
        crewManDao.delete(crewMan);
    }
}
