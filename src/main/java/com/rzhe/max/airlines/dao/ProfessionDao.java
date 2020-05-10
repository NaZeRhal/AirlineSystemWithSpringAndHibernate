package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.Profession;

import java.util.List;

public interface ProfessionDao {
    Profession findById(Long id) throws DaoException;

    List<Profession> findAll() throws DaoException;

    Long create(Profession profession) throws DaoException;

    void update(Profession profession) throws DaoException;

    void delete(Long id) throws DaoException;
}
