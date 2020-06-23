package com.rzhe.max.airlines.service;

import com.rzhe.max.airlines.entities.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    User save(User user);

    void delete(User user);

    User findByLogin(String login);
}
