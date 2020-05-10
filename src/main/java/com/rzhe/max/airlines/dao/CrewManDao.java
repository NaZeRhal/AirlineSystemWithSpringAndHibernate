package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.CrewMan;

import java.util.List;

public interface CrewManDao {
    CrewMan findById(Long id) throws DaoException;

    List<CrewMan> findAll() throws DaoException;

    Long create(CrewMan entity) throws DaoException;

    void update(CrewMan entity) throws DaoException;

    void delete(Long id) throws DaoException;
}
