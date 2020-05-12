package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.UserType;

import java.util.List;

public interface UserTypeDao {
    UserType findById(Long id);

    List<UserType> findAll();

    List<UserType> findAllWithUsers();

    UserType save(UserType userType);

    void delete(UserType userType);
}
