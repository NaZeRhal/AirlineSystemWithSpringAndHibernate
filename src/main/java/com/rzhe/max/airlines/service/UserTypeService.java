package com.rzhe.max.airlines.service;

import com.rzhe.max.airlines.entities.UserType;

import java.util.List;

public interface UserTypeService {
    UserType findById(Long id);

    List<UserType> findAll();

    List<UserType> findAllWithUsers();

    UserType save(UserType userType);

    void delete(UserType userType);
}
