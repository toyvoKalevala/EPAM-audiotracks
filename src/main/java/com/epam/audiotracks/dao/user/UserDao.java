package com.epam.audiotracks.dao.user;

import com.epam.audiotracks.dao.Dao;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {

    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;

    void changeUserDiscountByID(int discount, int id) throws DaoException;

}
