package com.rzhe.max.airlines.dao;

import com.rzhe.max.airlines.entities.UserType;

import java.util.List;

public interface UserTypeDao {
    UserType findById(Long id);

    List<UserType> findAll();

    List<UserType> findAllWithUsers();

    Long create(UserType userType);

    void update(UserType userType);

    void delete(Long id);
}
