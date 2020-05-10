package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);

    List<User> findAll();

    Long create(User user);

    void update(User user);

    void delete(Long id);

    User findByLogin(String login);
}
