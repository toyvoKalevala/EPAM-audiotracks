package com.epam.audiotracks.dao;

import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.DaoException;

import java.util.Optional;

public interface UserDao extends Dao {

    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;

}
