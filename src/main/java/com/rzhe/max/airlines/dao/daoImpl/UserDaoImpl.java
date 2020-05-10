package com.rzhe.max.airlines.dao.daoImpl;


import com.rzhe.max.airlines.dao.DaoException;
import com.rzhe.max.airlines.dao.UserDao;
import com.rzhe.max.airlines.entities.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

//    @Override
//    public String getSelectQuery() {
//        return "SELECT a.id, a.first_name, a.last_name, a.login, a.password, b.id as user_type_id, b.user_type_name FROM `user` a, user_type b " +
//                "WHERE a.user_type_id = b.id";
//    }
//
//    @Override
//    public String getCreateQuery() {
//        return "INSERT INTO `user` (first_name, last_name, login, `password`, user_type_id) " +
//                "VALUES (?, ?, ?, ?, ?)";
//    }
//
//    @Override
//    public String getUpdateQuery() {
//        return "UPDATE `user` SET first_name = ?, last_name = ?, login = ?, `password` = ?," +
//                "user_type_id = ? WHERE id = ?";
//    }
//
//    @Override
//    public String getDeleteQuery() {
//        return "DELETE FROM user WHERE id = ?";
//    }

    @Override
    public User findByLogin(String login) throws DaoException {
        return null;
    }

    @Override
    public User findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }

    @Override
    public Long create(User entity) throws DaoException {
        return null;
    }

    @Override
    public void update(User entity) throws DaoException {

    }

    @Override
    public void delete(Long id) throws DaoException {

    }
}
