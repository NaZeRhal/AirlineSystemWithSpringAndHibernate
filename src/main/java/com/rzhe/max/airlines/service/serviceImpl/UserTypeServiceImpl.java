package com.rzhe.max.airlines.service.serviceImpl;

import com.rzhe.max.airlines.dao.UserTypeDao;
import com.rzhe.max.airlines.entities.UserType;
import com.rzhe.max.airlines.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userTypeService")
@Transactional
public class UserTypeServiceImpl implements UserTypeService {
    private UserTypeDao userTypeDao;

    @Transactional(readOnly = true)
    @Override
    public UserType findById(Long id) {
        return userTypeDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserType> findAll() {
        return userTypeDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserType> findAllWithUsers() {
        return userTypeDao.findAllWithUsers();
    }

    @Override
    public UserType save(UserType userType) {
        return userTypeDao.save(userType);
    }

    @Override
    public void delete(UserType userType) {
        userTypeDao.delete(userType);
    }

    @Autowired
    public void setUserTypeDao(UserTypeDao userTypeDao) {
        this.userTypeDao = userTypeDao;
    }
}
