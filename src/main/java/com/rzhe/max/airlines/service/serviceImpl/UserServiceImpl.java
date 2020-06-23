package com.rzhe.max.airlines.service.serviceImpl;

import com.rzhe.max.airlines.dao.UserDao;
import com.rzhe.max.airlines.entities.User;
import com.rzhe.max.airlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
