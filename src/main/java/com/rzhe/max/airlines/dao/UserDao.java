package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.User;

public interface UserDao extends Dao<User, Long> {
    User findByLogin(String login) throws DaoException;
}
