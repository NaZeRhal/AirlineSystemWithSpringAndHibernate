package com.rzhe.max.airlines.dao.daoImpl;

import com.rzhe.max.airlines.dao.DaoException;
import com.rzhe.max.airlines.dao.UserTypeDao;
import com.rzhe.max.airlines.entities.UserType;

import java.util.List;

public class UserTypeDaoImpl implements UserTypeDao {

//    @Override
//    public String getSelectQuery() {
//        return "SELECT id, user_type_name FROM user_type";
//    }
//
//    @Override
//    public String getCreateQuery() {
//        return "INSERT INTO user_type (user_type_name) VALUES (?)";
//    }
//
//    @Override
//    public String getUpdateQuery() {
//        return "UPDATE user_type SET user_type_name = ?";
//    }
//
//    @Override
//    public String getDeleteQuery() {
//        return "DELETE FROM user_type WHERE id = ?";
//    }


    @Override
    public UserType findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public List<UserType> findAll() throws DaoException {
        return null;
    }

    @Override
    public Long create(UserType entity) throws DaoException {
        return null;
    }

    @Override
    public void update(UserType entity) throws DaoException {

    }

    @Override
    public void delete(Long id) throws DaoException {

    }
}
