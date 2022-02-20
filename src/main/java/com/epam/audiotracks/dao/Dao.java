package com.epam.audiotracks.dao;

import com.epam.audiotracks.exeption.DaoException;

import java.sql.Connection;

public interface Dao {

    void close(Connection connection) throws DaoException;
}
