package com.epam.audiotracks.dao.assembly;

import com.epam.audiotracks.dao.Dao;
import com.epam.audiotracks.entity.Assembly;
import com.epam.audiotracks.exeption.DaoException;

public interface AssemblyDao extends Dao<Assembly> {

    void save(String name) throws DaoException;

    void save(int trackId, int assemblyId) throws DaoException;

}
