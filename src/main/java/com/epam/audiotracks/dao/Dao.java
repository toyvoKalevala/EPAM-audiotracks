package com.epam.audiotracks.dao;

import com.epam.audiotracks.exeption.DaoException;

import java.util.List;

public interface Dao<T> {

    List<T> findAll() throws DaoException;

}
